package com.learn.base.pattern.proxy.cglibProxy.asm;


import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;


/**
 * @program: learn
 * @description: asm创建一个新类
 * @author: Elliot
 * @create: 2019-09-22 18:42
 **/
public class CreateNewClass {

    public static void main(String[] args) throws IOException {
        ClassWriter cw=new ClassWriter(0);
        //类版本，访问标志以及修饰符，类全名，泛型，父类，接口
        cw.visit(V1_7,ACC_PUBLIC+ACC_ABSTRACT+ACC_INTERFACE,
                "com.learn.base.pattern.proxy.cglibProxy.asm/NewClass",null,"java/lang/Object",
                new String[]{"com/learn/base/pattern/proxy/cglibProxy/asm/INewClass"});
        //访问标志，名字，类型，泛型，值
        cw.visitField(ACC_PUBLIC+ACC_STATIC+ACC_FINAL,"LESS","I",
                null,new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC+ACC_STATIC+ACC_FINAL,"EQUAL","I",
                null,new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC+ACC_STATIC+ACC_FINAL,"GRATER","I",
                null,new Integer(1)).visitEnd();
        //访问标志，名字，签名，泛型，throws异常
        cw.visitMethod(ACC_PUBLIC+ACC_ABSTRACT,"compareTo","(Ljava/lang/Object;)I",
                null,null).visitEnd();

        cw.visitEnd();//通知classWriter，类定义完成了
        String systemRootUrl = (new File("")).toURI().toURL().getPath();
        File file=new File(systemRootUrl+"base/src/main/java/com/learn/base/pattern/proxy/cglibProxy/asm/NewClass.class");
        String parent=file.getParent();
        File parent1=new File(parent);
        parent1.mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(cw.toByteArray());
    }
}
