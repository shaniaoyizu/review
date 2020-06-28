package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test06 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-properties.xml");

    @Test
    public void test01() throws SQLException {
        DataSource dataSource = (DataSource)ioc.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
