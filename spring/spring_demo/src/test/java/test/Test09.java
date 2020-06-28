package test;

import com.sunbc.beans.factory.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test09 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-factory.xml");

    @Test
    public void test01() throws SQLException {
        Car car = (Car) ioc.getBean("car1");
        System.out.println(car);
    }

    @Test
    public void test02() throws SQLException {
        Car car = (Car) ioc.getBean("car2");
        System.out.println(car);
    }
}
