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
public class Test05 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-scope.xml");

    @Test
    public void test01(){

    }
}
