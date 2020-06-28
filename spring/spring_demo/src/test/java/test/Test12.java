package test;

import com.sunbc.beans.generic.di.UserService;
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
public class Test12 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-generic-di.xml");

    @Test
    public void test01() {
        UserService userService = (UserService) ioc.getBean("userService");
        userService.add();
    }

}
