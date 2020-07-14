package com.sunbc.restful.controller;

import com.sunbc.restful.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello/{msg}")
    public String hello(@PathVariable("msg") String msg){
        if ("msg".equals(msg)){
            throw new UserNotExistException("用户不存在");
        }
        return "Hello World";
    }
}
