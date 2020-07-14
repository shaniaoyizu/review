package com.sunbc.wraptest.controller;

import com.sunbc.wrap.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-07-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class SomeController {

    @Autowired
    private SomeService service;

    @RequestMapping("/some/{param}")
    public String someServiceHandler(@PathVariable("param") String word){
        return service.wrap(word);
    }
}
