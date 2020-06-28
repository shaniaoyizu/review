package com.sunbc.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }
}
