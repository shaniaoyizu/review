package com.sunbc.service;

import com.sunbc.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2020-09-04
 *
 * @author sunbc
 * @Describe
 * @since
 */
//关于Feign说明：
//1)Feign接口名一般是与业务接口名相同的，但是不是必须的
//2)Feign接口中的方法名一般也是与业务接口方法名相同,但是也不是必须的
//3)Feign接口中的方法返回值类型和方法参数要求与业务接口中的相同
//4)接口上与方法上的Mapping的参数URI要与提供者处理器响应方法上的Mapping的URI相同

//指定当前为Feign客户端，参数为提供者的微服务名称
// fallbackFactory用于指定当前Feign接口的服务降级类
@Component
@FeignClient(value = "msc-provider-depart",fallbackFactory = DepartFallbackFactory.class)
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/")
    boolean saveDepart(@RequestBody Depart depart);
    @DeleteMapping("/{id}")
    boolean removeDepartById(@PathVariable("id") Integer id);
    @PutMapping("/")
    boolean modifyDepart(@RequestBody Depart depart);
    @GetMapping("/{id}")
    Depart getDepartById(@PathVariable("id") Integer id);
    @GetMapping("/")
    List<Depart> listAllDeparts();
}
