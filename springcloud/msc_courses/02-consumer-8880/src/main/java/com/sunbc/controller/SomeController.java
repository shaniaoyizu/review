package com.sunbc.controller;

import com.sunbc.bean.Depart;
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

    //直连
//    private final static String SERVICE_PROVIDER = "http://localhost:8881";
    //使用微服务名称来来从eureka server查找
    private final static String SERVICE_PROVIDER = "http://msc-provider-depart";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable("id") Integer id){
        String url = SERVICE_PROVIDER + "/provider/depart/" + id;
        restTemplate.delete(url,id);
    }

    @PutMapping("/")
    public void updateHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        restTemplate.put(url,depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") Integer id){
        String url = SERVICE_PROVIDER + "/provider/depart/" + id;
        return restTemplate.getForObject(url,Depart.class);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        return restTemplate.getForObject(url,List.class);
    }
}
