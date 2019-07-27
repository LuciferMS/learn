package com.learn.base.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: learn
 * @description: MyClassLoader 自定义类加载器
 * @author: Elliot
 * @create: 2019-07-27 23:33
 **/
public class MyClassLoader extends ClassLoader{

    private static final String CLASS_FILE_SUFFIX = ".class";

    /**
     * AppClassLoader的父类加载器
     */
    private ClassLoader extClassLoader;

    public MyClassLoader() {
        ClassLoader j = String.class.getClassLoader();
        if (j == null){
            j = getSystemClassLoader();
            while(j.getParent() != null){
                j = j.getParent();
            }
        }
        this.extClassLoader = j;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class cls = null;
        cls = findLoadedClass(name);
        if (cls != null){
            return cls;
        }

        ClassLoader extClassLoader = getExtClassLoader();
        try{
            cls = extClassLoader.loadClass(name);
            if (cls != null){
                return cls;
            }
        }catch (ClassNotFoundException e){

        }
        cls = findClass(name);
        return cls;
    }

    private byte[] loadClassData(String className){
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + CLASS_FILE_SUFFIX);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        try {
            while((len = is.read()) != -1){
                byteArrayOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public ClassLoader getExtClassLoader() {
        return extClassLoader;
    }
}
