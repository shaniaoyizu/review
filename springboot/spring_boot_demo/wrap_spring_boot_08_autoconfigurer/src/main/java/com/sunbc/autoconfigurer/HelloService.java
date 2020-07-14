package com.sunbc.autoconfigurer;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class HelloService {

    private HelloProperties properties;

    public void setProperties(HelloProperties properties) {
        this.properties = properties;
    }

    public String sayHello(String name) {
        return properties.getPrefix() + "-" + name + "-" + properties.getSuffix();
    }
}
