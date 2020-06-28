package com.sunbc.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunbc.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestMpAr {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test(){
        Employee employee = new Employee();
        employee.setLastName("小影");
        employee.setEmail("xiaoying@xx.com");
        employee.setGender(1);
        employee.setAge(31);
        boolean insert = employee.insert();
        System.out.println(insert);
    }

    @Test
    public void test02(){
        Employee employee = new Employee();
        employee.setId(15);
        employee.setLastName("小影");
        employee.setEmail("xiaoying@xx.com");
        employee.setGender(1);
        employee.setAge(30);
        boolean b = employee.updateById();
        System.out.println(b);
    }

    @Test
    public void test03(){
        Employee employee = new Employee();
//        Employee employee1 = employee.selectById(15);
//        System.out.println(employee1);

        employee.setId(15);
        Employee employee1 = employee.selectById();
        System.out.println(employee1);
    }

    @Test
    public void test04(){
        Employee employee = new Employee();
        List<Employee> list = employee.selectAll();
        System.out.println(list);

        List<Employee> employeeList = employee.selectList(new QueryWrapper<Employee>().like("last_name", "老师"));
        System.out.println(employeeList);

        Integer count = employee.selectCount(new QueryWrapper<Employee>().eq("gender", 0));
        System.out.println(count);
    }

    @Test
    public void test05(){
        Employee employee = new Employee();
//        boolean b = employee.deleteById(1);
//        System.out.println(b);
//        employee.setId(1);
//        boolean b = employee.deleteById();
//        System.out.println(b);

        boolean delete = employee.delete(new QueryWrapper<Employee>().like("last_name", "母"));
        System.out.println(delete);
    }

    @Test
    public void test06(){
        Employee employee = new Employee();
        Page<Employee> employeePage = employee.selectPage(new Page<>(1, 2),
                new QueryWrapper<Employee>().eq("gender", 1));
        System.out.println(employeePage.getTotal());
        System.out.println(employeePage.getRecords());
    }
}
