package com.sunbc.mapper;

import com.sunbc.bean.Employee;

/**
 * Created on 2020-06-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface EmployeeMapper {
    Employee getEmpById(Integer id);

//    Long updateEmp(@Param("tableName")String tableName, @Param("emp")Employee employee);
}
