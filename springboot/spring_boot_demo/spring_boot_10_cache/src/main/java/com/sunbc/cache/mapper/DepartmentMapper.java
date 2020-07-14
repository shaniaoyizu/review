package com.sunbc.cache.mapper;

import com.sunbc.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
