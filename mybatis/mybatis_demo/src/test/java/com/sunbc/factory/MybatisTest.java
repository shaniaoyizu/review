package com.sunbc.factory;

import com.sunbc.bean.Department;
import com.sunbc.bean.Employee;
import com.sunbc.mapper.DepartmentMapper;
import com.sunbc.mapper.EmployeeMapper;
import com.sunbc.mapper.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020-06-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MybatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        try(SqlSession openSession = sqlSessionFactory.openSession()) {
            Employee employee = openSession.selectOne("EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }
    }

    @Test
    public void test02(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.getClass());
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test03(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test04(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null,"流","xiao@xiao.com","0");
            System.out.println(mapper.addEmp(employee));
            System.out.println(employee.getId());
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void test05(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpByIdAndName(1, "晓");
            System.out.println(employee);
        }
    }

    @Test
    public void test06(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.getEmpByLastNameLike("晓");
            System.out.println(list);
        }
    }

    @Test
    public void test07(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
            System.out.println(map);
        }
    }

    @Test
    public void test08(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> map = mapper.getEmpByLastNameReturnMap("晓");
            System.out.println(map);
        }
    }

    @Test
    public void test09(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpAndDept(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test10(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpByIdStep(2);
            System.out.println(employee);
            System.out.println(employee.getDept());
        }
    }

    @Test
    public void test11(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dept = mapper.getDeptByIdPlus(1);
            System.out.println(dept);
            System.out.println(dept.getEmps());
        }
    }

    @Test
    public void test12(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department dept = mapper.getDeptByIdStep(1);
            System.out.println(dept.getDeptName());
            System.out.println("---------------------");
            System.out.println(dept.getEmps());
        }
    }
}
