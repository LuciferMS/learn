package com.learn.base.pattern.proxy.cglibProxy.asm;


import org.objectweb.asm.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: learn
 * @description: dmeoClassReader
 * @author: Elliot
 * @create: 2019-09-22 18:34
 **/
public class DemoClassReader extends ClassVisitor {

    public DemoClassReader() {
        super(Opcodes.ASM6);
    }

    public DemoClassReader(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + "extend" + superName + "implements" + interfaces);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println(" " + descriptor + " " + name);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println(" " + name + descriptor);
        return null;
    }

    public static void main(String[] args) throws IOException {
        DemoClassReader demoClassReader = new DemoClassReader();
        InputStream in = ClassLoader.getSystemResourceAsStream(Demo.class.getName().replace(".", "/" ) + ".class");
        ClassReader classReader = new ClassReader(in);
        classReader.accept(demoClassReader, 0);
    }
}
