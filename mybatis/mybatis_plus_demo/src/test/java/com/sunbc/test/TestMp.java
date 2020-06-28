package com.sunbc.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunbc.beans.Employee;
import com.sunbc.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-06-24
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestMp {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void test() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test02(){
        Employee employee = new Employee();
        employee.setLastName("Jack");
        employee.setEmail("jack@x.com");
        employee.setGender(0);
        employee.setAge(30);
        int insert = mapper.insert(employee);
        System.out.println(insert);
    }

    @Test
    public void test03(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("圣母");
        employee.setEmail("marria@x.com");
        employee.setGender(1);
//        employee.setAge(20);
        int update = mapper.updateById(employee);
        System.out.println(update);
    }

    @Test
    public void test04(){
//        Employee employee = mapper.selectById(6);
//        System.out.println(employee);

//        Employee employee = new Employee();
//        employee.setId(6);
//        employee.setLastName("MP");
//        employee.setGender(1);
//        Employee one = mapper.selectOne(new QueryWrapper<>(employee));
//        System.out.println(one);

//        List<Integer> idList = new ArrayList<>();
//        idList.add(4);
//        idList.add(5);
//        idList.add(6);
//        List<Employee> list = mapper.selectBatchIds(idList);
//        System.out.println(list);

//        Map<String,Object> columnMap = new HashMap<>();
//        columnMap.put("last_name","MP");
//        columnMap.put("gender","1");
//        List<Employee> list = mapper.selectByMap(columnMap);
//        System.out.println(list);

        Page<Employee> employeePage = mapper.selectPage(new Page<>(1, 2), null);
        System.out.println(employeePage.getPages());
        System.out.println(employeePage.getCurrent());
        System.out.println(employeePage.getSize());
        System.out.println(employeePage.getTotal());
        System.out.println(employeePage.getRecords());
    }

    @Test
    public void test05(){
//        int delete = mapper.deleteById(12);
//        System.out.println(delete);

//        Map<String,Object> columnMap = new HashMap<>();
//        columnMap.put("last_name","MP");
//        columnMap.put("gender","1");
//        int delete = mapper.deleteByMap(columnMap);
//        System.out.println(delete);

        List<Integer> idList = new ArrayList<>();
        idList.add(10);
        idList.add(11);
        int deleteBatchIds = mapper.deleteBatchIds(idList);
        System.out.println(deleteBatchIds);
    }

    @Test
    public void test06(){
//        Page<Employee> employeePage = mapper.selectPage(new Page<>(1, 2),
//                new QueryWrapper<Employee>()
//                        .between("age", 18, 50)
//                        .eq("gender", 1)
//                        .eq("last_name", "Tom"));
//        System.out.println(employeePage.getRecords());

        List<Employee> employees = mapper.selectList(new QueryWrapper<Employee>()
                .eq("gender", 0)
                .like("last_name", "i")
                .or()
                .like("last_name", "老师"));
        System.out.println(employees);
    }

    @Test
    public void test07(){
        Employee employee = new Employee();
        employee.setLastName("李老师");
        employee.setEmail("li@li.com");
        int update = mapper.update(employee, new QueryWrapper<Employee>().eq("last_name", "Tom").eq("gender", 1));
        System.out.println(update);
    }

    @Test
    public void test08(){
        int delete = mapper.delete(new QueryWrapper<Employee>().eq("last_name", "李老师").eq("age", 20));
        System.out.println(delete);
    }

    @Test
    public void test09(){
        List<Employee> list = mapper.selectList(new QueryWrapper<Employee>().eq("gender", 0).orderByAsc("age"));
        System.out.println(list);
    }

    @Test
    public void test10(){
        int delete = mapper.delete(null);
        System.out.println(delete);
    }

    @Test
    public void test11(){
        int i = mapper.deleteAll();
        System.out.println(i);
    }
}
