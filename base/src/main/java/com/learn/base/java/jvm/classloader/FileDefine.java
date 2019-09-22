package com.learn.base.java.jvm.classloader;

/**
 * @program: learn
 * @description: 封装file
 * @author: Elliot
 * @create: 2019-07-28 00:00
 **/
public class FileDefine {

    public static String WATCH_PACKAGE = "E:\\ideaPro\\learn\\base\\src\\main\\java\\base\\classLoader";

    private String fileName;

    private Long lastDefine;


    public static String getWatchPackage() {
        return WATCH_PACKAGE;
    }

    public static void setWatchPackage(String watchPackage) {
        WATCH_PACKAGE = watchPackage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getLastDefine() {
        return lastDefine;
    }

    public void setLastDefine(Long lastDefine) {
        this.lastDefine = lastDefine;
    }

    public FileDefine(String fileName, Long lastDefine) {
        this.fileName = fileName;
        this.lastDefine = lastDefine;
    }
}
