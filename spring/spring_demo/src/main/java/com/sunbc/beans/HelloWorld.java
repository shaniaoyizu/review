package com.sunbc.beans;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("hello：" + name);
    }
}
