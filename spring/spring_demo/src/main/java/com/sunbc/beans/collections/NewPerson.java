package com.sunbc.beans.collections;

import com.sunbc.beans.Car;

import java.util.Map;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class NewPerson {

    private String name;
    private int age;
    private Map<String,Car> cars;

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

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public NewPerson() {
    }

    public NewPerson(String name, int age, Map<String, Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "NewPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
