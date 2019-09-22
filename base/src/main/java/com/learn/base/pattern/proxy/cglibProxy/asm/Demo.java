package com.learn.base.pattern.proxy.cglibProxy.asm;

/**
 * @program: learn
 * @description: demo类
 * @author: Elliot
 * @create: 2019-09-22 18:34
 **/
public class Demo {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Demo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
