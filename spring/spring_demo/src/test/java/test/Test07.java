package test;

import com.sunbc.beans.spel.Address;
import com.sunbc.beans.spel.Car;
import com.sunbc.beans.spel.Person;
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
public class Test07 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-spel.xml");

    @Test
    public void test01() throws SQLException {
        Address address = (Address)ioc.getBean("address");
        System.out.println(address);

        Car car = (Car) ioc.getBean("car");
        System.out.println(car);

        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }
}
