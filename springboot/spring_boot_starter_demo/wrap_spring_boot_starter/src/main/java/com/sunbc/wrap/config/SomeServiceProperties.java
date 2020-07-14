package com.sunbc.wrap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created on 2020-07-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Data
@ConfigurationProperties("some.service")
public class SomeServiceProperties {

    private String prefix;
    private String suffix;

}
