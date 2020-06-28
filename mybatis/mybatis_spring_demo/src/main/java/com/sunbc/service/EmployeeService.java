package com.sunbc.service;

import com.sunbc.bean.Employee;
import com.sunbc.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020-06-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmps(){
        return employeeMapper.getEmps();
    }
}
