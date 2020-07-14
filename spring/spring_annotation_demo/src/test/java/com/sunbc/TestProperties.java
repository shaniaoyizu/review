package com.sunbc;

import com.sunbc.bean.Person;
import com.sunbc.config.MyConfigOfPropertiesValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestProperties {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfigOfPropertiesValues.class);

    @Test
    public void test01(){
        printBeans(ctx);
        System.out.println("============================");

        Person person = (Person)ctx.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = ctx.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        ctx.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }
}
