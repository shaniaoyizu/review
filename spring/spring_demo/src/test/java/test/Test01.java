package test;

import com.sunbc.beans.Car;
import com.sunbc.beans.HelloWorld;
import com.sunbc.beans.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test01 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        HelloWorld helloWorld = ioc.getBean("helloWorld", HelloWorld.class);
        helloWorld.hello();
    }

    @Test
    public void test02(){
        Car car = ioc.getBean("car",Car.class);
        System.out.println(car);

        Car car2 = ioc.getBean("car2",Car.class);
        System.out.println(car2);

        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);

        Person person2 = ioc.getBean("person2", Person.class);
        System.out.println(person2);
    }
}
