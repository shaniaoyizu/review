package com.sunbc.beans.spel;

import com.sunbc.beans.spel.Address;
import com.sunbc.beans.spel.Car;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Person {
    private String name;
    public Car car;
    private String city;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
