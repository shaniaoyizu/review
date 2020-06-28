package com.sunbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunbc.beans.Employee;

/**
 * Created on 2020-06-24
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface EmployeeMapper extends BaseMapper<Employee>{

    int deleteAll();
}
