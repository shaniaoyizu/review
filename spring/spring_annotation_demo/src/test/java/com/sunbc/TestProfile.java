package com.sunbc;

import com.sunbc.config.MyConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestProfile {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(MyConfigOfProfile.class);
        context.refresh();

        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name :  names){
            System.out.println(name);
        }
    }
}


