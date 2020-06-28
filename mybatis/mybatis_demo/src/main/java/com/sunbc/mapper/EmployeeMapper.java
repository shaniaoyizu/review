package com.sunbc.mapper;

import com.sunbc.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

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

    Long addEmp(Employee employee);

    Long updateEmp(Employee employee);

    Long deleteEmp(Integer id);

    Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

    List<Employee> getEmpByLastNameLike(String lastName);

    Map<String,Object> getEmpByIdReturnMap(Integer id);

    @MapKey("id")
//    @MapKey("lastName")
    Map<Integer,Employee> getEmpByLastNameReturnMap(String lastName);

    Employee getEmpAndDept(Integer id);

    Employee getEmpByIdStep(Integer id);

    List<Employee> getEmpByDeptId(Integer deptId);

    List<Employee> getEmps();
}
