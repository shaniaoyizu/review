package com.sunbc.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class InstanceCarFactory {

    private Map<String,Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",500000));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
