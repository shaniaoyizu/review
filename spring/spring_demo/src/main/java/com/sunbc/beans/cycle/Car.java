package com.sunbc.beans.cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Car implements InitializingBean,DisposableBean {

    private String brand;
    private double price;

    public Car() {
        System.out.println("car......");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("setPrice...");
        this.price = price;
    }

    public void init1(){
        System.out.println("init-method......");
    }

    public void destroy1(){
        System.out.println("destroy-method......");
    }

    @PostConstruct
    public void init2(){
        System.out.println("@PostConstruct......");
    }

    @PreDestroy
    public void destroy2(){
        System.out.println("@PreDestroy......");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy......");
    }
}
