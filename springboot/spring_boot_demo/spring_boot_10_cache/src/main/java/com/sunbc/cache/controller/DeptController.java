package com.sunbc.cache.controller;

import com.sunbc.cache.bean.Department;
import com.sunbc.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-07-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id")Integer id){
        return deptService.getDeptById(id);
    }
}
