package com.learn.base.spring;

/**
 * @program: learn
 * @description: Spring测试Bean
 * @author: Elliot
 * @create: 2019-06-30 23:04
 **/
public class SimpleBean {
    private int id;
    private String name = "Default Name";

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
