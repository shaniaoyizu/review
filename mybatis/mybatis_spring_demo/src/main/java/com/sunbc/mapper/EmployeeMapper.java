package com.sunbc.mapper;

import com.sunbc.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-06-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    List<Employee> getEmps();
}
