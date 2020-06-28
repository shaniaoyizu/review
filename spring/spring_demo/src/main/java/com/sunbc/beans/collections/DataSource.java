package com.sunbc.beans.collections;

import java.util.Properties;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class DataSource {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
