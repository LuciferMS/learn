package com.learn.base.java.jvm.classloader;

import java.io.File;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: learn
 * @description: run
 * @author: Elliot
 * @create: 2019-07-28 00:03
 **/
public class Main {
    public static Map<String,FileDefine> fileDefineMap = new HashMap<>();

    public static void main(String[] args){
        initMap();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new WatchDog(fileDefineMap), 0,500, TimeUnit.MICROSECONDS);
    }

    public static void initMap(){
        File file = new File(FileDefine.WATCH_PACKAGE);
        File[] files = file.listFiles();
        for (File watchFile : files){
            long l = watchFile.lastModified();
            String name = watchFile.getName();
            FileDefine fileDefine = new FileDefine(name,l);
            fileDefineMap.put(name,fileDefine);
        }
    }
}
