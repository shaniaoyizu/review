package com.sunbc.ss.beans;

/**
 * Created on 2020-07-02
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("My name is " + name);
    }
}
