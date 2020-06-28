package test;

import com.sunbc.beans.annotation.TestObject;
import com.sunbc.beans.annotation.controller.UserController;
import com.sunbc.beans.annotation.respository.UserRepository;
import com.sunbc.beans.annotation.service.UserService;
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
public class Test11 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-annotation.xml");

    @Test
    public void test01() throws SQLException {
        TestObject testObject = (TestObject)ioc.getBean("testObject");
        System.out.println(testObject);

        UserService userService = (UserService)ioc.getBean("userService");
        System.out.println(userService);

        UserRepository userRepository = (UserRepository) ioc.getBean("userRepository");
        System.out.println(userRepository);

        UserController userController = (UserController) ioc.getBean("userController");
        System.out.println(userController);
    }

}
