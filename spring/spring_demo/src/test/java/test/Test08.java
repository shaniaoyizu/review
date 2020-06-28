package test;

import com.sunbc.beans.cycle.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test08 {

    ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans-cycle.xml");

    @Test
    public void test01() throws SQLException {
        Car car = (Car) ioc.getBean("car");
        System.out.println(car);
        ioc.close();
    }
}
