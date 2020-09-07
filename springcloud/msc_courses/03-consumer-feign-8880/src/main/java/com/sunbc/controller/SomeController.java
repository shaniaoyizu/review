package com.sunbc.controller;

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

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") Integer id){
        return service.getDepartById(id);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return service.listAllDeparts();
    }
}
