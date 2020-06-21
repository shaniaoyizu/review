package com.sunbc.mapper;

import com.sunbc.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * Created on 2020-06-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface EmployeeMapperAnnotation {

    @Select("SELECT * FROM tb_employee WHERE id =  #{id}")
    Employee getEmpById(Integer id);
}
