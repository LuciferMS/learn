package com.learn.base.java.concurrent.thread;

public class UserTestBean {
    private String name;
    private int age;

    public UserTestBean() {
        this.name = "Elliot";
        this.age = 20;
    }

    public UserTestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
