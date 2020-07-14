package com.sunbc.cache.service;

import com.sunbc.cache.bean.Employee;
import com.sunbc.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Created on 2020-07-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@CacheConfig(cacheNames = "emp",cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp"/*,keyGenerator = "myKeyGenerator",condition = "#a0>1"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @CachePut(/*value = "emp",*/ key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp: " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(/*value = "emp",*/ key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp: " + id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(/*value = "emp",*/ key = "#lastName")
            },
            put = {
                    @CachePut(/*value = "emp",*/ key = "#result.id", unless = "#result == null "),
                    @CachePut(/*value = "emp",*/ key = "#result.email", unless = "#result == null ")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
