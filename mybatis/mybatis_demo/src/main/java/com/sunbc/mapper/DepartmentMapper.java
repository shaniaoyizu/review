package com.sunbc.mapper;

import com.sunbc.bean.Department;

/**
 * Created on 2020-06-20
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface DepartmentMapper {
    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);

    Department getDeptByIdStep(Integer id);
}
