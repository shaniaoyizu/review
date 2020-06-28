package test;

import com.sunbc.beans.autowire.Address;
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
public class Test04 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-relation.xml");

    @Test
    public void test01(){
//        Address address = (Address)ioc.getBean("address");
//        System.out.println(address);

        Address address2 = (Address)ioc.getBean("address2");
        System.out.println(address2);

        Address address3 = (Address)ioc.getBean("address3");
        System.out.println(address3);

        Person person = (Person)ioc.getBean("person");
        System.out.println(person);
    }
}
