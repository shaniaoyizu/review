package com.sunbc.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2020-07-01
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Controller
public class SpringMVCHandler {

    @RequestMapping("hello")
    public String handleHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
