package test;

import com.sunbc.beans.factorybean.Car;
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
public class Test10 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-beanfactory.xml");

    @Test
    public void test01() throws SQLException {
        Car car = (Car) ioc.getBean("car");
        System.out.println(car);
    }

}
