package com.sunbc.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Nullable
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,300000);
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
