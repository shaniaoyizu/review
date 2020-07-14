package com.sunbc.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created on 2020-07-01
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Controller
public class Springmvc2Handler {

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("username","Admin");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("testMap")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("password","123456");
        return "success";
    }

    @RequestMapping("testModel")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("loginMsg","用户名或密码错误");
        return "success";
    }

    @RequestMapping("testView")
    public String testView(){
        return "success";
    }
}
