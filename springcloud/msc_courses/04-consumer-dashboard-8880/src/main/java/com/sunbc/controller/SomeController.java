package com.sunbc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunbc.bean.Depart;
import com.sunbc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @HystrixCommand(fallbackMethod = "getHystrixHandler",
        commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"))
    @GetMapping("/{id}")
    public Depart getById(@PathVariable("id") int id){
        return service.getDepartById(id);
    }

    public Depart getHystrixHandler(@PathVariable("id") int id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart -- method");
        return depart;
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return service.listAllDeparts();
    }
}
