package com.sunbc.autoconfigurer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
@ConfigurationProperties(prefix = "com.sunbc.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
