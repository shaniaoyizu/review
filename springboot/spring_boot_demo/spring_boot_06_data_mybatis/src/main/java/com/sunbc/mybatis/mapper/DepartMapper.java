package com.sunbc.mybatis.mapper;

import com.sunbc.mybatis.beans.Department;
import org.apache.ibatis.annotations.*;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
//@Mapper
public interface DepartMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    int deleteDeptById();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    int updateDept(Department department);
}
