package com.sunbc.mybatis.controller;

import com.sunbc.mybatis.beans.Department;
import com.sunbc.mybatis.beans.Employee;
import com.sunbc.mybatis.mapper.DepartMapper;
import com.sunbc.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class DeptController {

    @Autowired
    DepartMapper departMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){
        return employeeMapper.getEmpById(id);
    }
}
