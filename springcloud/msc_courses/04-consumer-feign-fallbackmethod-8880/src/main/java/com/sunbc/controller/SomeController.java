package com.sunbc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunbc.bean.Depart;
import com.sunbc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
@RequestMapping("/consumer/depart")
public class SomeController {

    @Autowired
    private DepartService service;

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        return service.saveDepart(depart);
    }

    @DeleteMapping("/{id}")
    public boolean deleteHandler(@PathVariable("id") Integer id){
        return service.removeDepartById(id);
    }

    @PutMapping("/")
    public boolean updateHandler(@RequestBody Depart depart){
        return service.modifyDepart(depart);
    }

    // 指定该方法要使用服务降级。即当当处理器方法在运行过程中若发生异常
    // 无法给客户端正常响应时，就会调用fallbackmethod指定的方法
    @HystrixCommand(fallbackMethod = "getHystrixHandler")
    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") Integer id){
        return service.getDepartById(id);
    }

    //定义服务降级方法，即响应给客户端的备选方案
    public Depart getHystrixHandler(@PathVariable("id") Integer id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart");
        return depart;
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return service.listAllDeparts();
    }
}
