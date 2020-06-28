package com.sunbc.test;

import com.sunbc.beans.User;
import com.sunbc.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestUser {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserMapper mapper = ioc.getBean("userMapper",UserMapper.class);

    @Test
    public void test(){
//        int delete = mapper.deleteById(1);
//        System.out.println(delete);

        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        User user = new User();
        user.setName("Tom");
        int insert = mapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void test03(){
        User user = new User();
        user.setId(6);
        user.setName("Jerry");
        int update = mapper.updateById(user);
        System.out.println(update);
    }
}
