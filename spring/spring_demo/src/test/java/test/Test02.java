package test;

import com.sunbc.beans.collections.DataSource;
import com.sunbc.beans.collections.NewPerson;
import com.sunbc.beans.collections.Person;
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
public class Test02 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        Person person3 = ioc.getBean("person3", Person.class);
        System.out.println(person3);

        Person person4 = ioc.getBean("person4", Person.class);
        System.out.println(person4);

        Person person5 = ioc.getBean("person5", Person.class);
        System.out.println(person5);
    }

    @Test
    public void test02(){
        NewPerson newPerson = ioc.getBean("newPerson", NewPerson.class);
        System.out.println(newPerson);
    }

    @Test
    public void test03(){
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }
}
