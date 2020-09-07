import com.sunbc.bean.Employee;
import com.sunbc.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 2020-08-22
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test01 {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = employeeMapper.getEmpById(1);
            System.out.println(emp);

            emp = employeeMapper.getEmpById(1);
            System.out.println(emp);
        }
    }

    @Test
    public void test02(){
//        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Long count = mapper.updateEmp("tb_employee", new Employee(8, "晓颖", "xiaoying@mm.com", "0", 2));
//            System.out.println(count);
//        }
    }
}
