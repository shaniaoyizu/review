package com.sunbc.controller;

import com.sunbc.bean.Depart;
import com.sunbc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DepartService service;

    @Autowired //声明服务发现
    private DiscoveryClient client;

    @Value("${suffix}")
    private String suffix;

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        depart.setName(depart.getName() + suffix);
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

    @GetMapping("/discovery")
    public List<String> discoveryHandler(){
        List<String> services = client.getServices();
        for (String name : services){
            // 获取当前遍历微服务名称的所有提供者主机
            List<ServiceInstance> instances = client.getInstances(name);
            // 遍历所有提供者主机的详情
            for (ServiceInstance instance : instances){
                // 获取当前提供者的唯一标识，service id
                String serviceId = instance.getServiceId();
                String instanceId = instance.getInstanceId();
                // 获取当前提供者主机的host
                String host = instance.getHost();
                Map<String, String> metadata = instance.getMetadata();
                System.out.println("serviceId = " + serviceId + "\n\t"
                        + ",instanceId = " + instanceId+ "\n\t"
                        + ",host = " + host + "\n\t"
                        + ",metadata = " + metadata);
            }
        }
        return services;
    }
}
