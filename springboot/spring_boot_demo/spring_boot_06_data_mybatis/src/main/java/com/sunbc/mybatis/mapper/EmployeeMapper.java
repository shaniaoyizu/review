package com.sunbc.mybatis.mapper;

import com.sunbc.mybatis.beans.Employee;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmployee(Employee employee);
}
