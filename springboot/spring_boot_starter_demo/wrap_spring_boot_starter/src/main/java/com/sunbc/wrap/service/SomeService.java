package com.sunbc.wrap.service;

import lombok.AllArgsConstructor;

/**
 * Created on 2020-07-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
@AllArgsConstructor
public class SomeService {

    private String before;
    private String later;

    public String wrap(String word){
        return  before + word + later;
    }
}
