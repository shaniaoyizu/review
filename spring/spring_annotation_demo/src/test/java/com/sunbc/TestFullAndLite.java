package com.sunbc;

import com.sunbc.bean.User;
import com.sunbc.config.AppConfig;
import com.sunbc.config.LiteAppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestFullAndLite {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.hashCode());
        context.close();
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LiteAppConfig.class);
        System.out.println("====================================");
        User user = context.getBean(User.class);
        System.out.println(user);
        System.out.println(user.hashCode());
        context.close();
    }
}
