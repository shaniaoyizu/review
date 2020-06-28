package test;

import com.sunbc.beans.autowire.Person;
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
public class Test03 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-autowire.xml");

    @Test
    public void test01(){
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);
    }
}
