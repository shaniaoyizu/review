package com.sunbc.controller;

import com.sunbc.bean.Employee;
import com.sunbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-06-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String emps(Map<String,Object> map){
        List<Employee> emps = employeeService.getEmps();
        map.put("emps",emps);
        return "list";
    }
}
