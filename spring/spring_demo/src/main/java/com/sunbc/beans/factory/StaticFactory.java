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
public class StaticFactory {

    private static Map<String,Car> cars = new HashMap<>();

    static {
        cars.put("audi",new Car("audi",300000));
        cars.put("for",new Car("for",500000));
    }

    public static Car getCar(String name){
        return cars.get(name);
    }
}
