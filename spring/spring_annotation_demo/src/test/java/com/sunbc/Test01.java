package com.sunbc;

import com.sunbc.bean.Blue;
import com.sunbc.bean.Person;
import com.sunbc.config.MyConfig;
import com.sunbc.config.MyConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test01 {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig2.class);

    @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test02(){
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean);

        String[] namesForType = ctx.getBeanNamesForType(Person.class);
        for (String name : namesForType){
            System.out.println(name);
        }
    }

    @Test
    public void test03(){
        String[] definitionNames = ctx.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void test04(){
        String[] definitionNames = ctx.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }

        Object person = ctx.getBean("person");
        Object person2 = ctx.getBean("person");
        System.out.println(person == person2);
    }


    @Test
    public void test05(){
        Environment environment = ctx.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] namesForType = ctx.getBeanNamesForType(Person.class);
        for (String name : namesForType){
            System.out.println(name);
        }

        Map<String, Person> personMap = ctx.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    @Test
    public void testImport(){
        printBeans(ctx);
        Blue blue = ctx.getBean(Blue.class);
        System.out.println(blue);

        Object colorFactoryBean = ctx.getBean("colorFactoryBean");
        System.out.println("bean类型：" + colorFactoryBean.getClass());

        colorFactoryBean = ctx.getBean("&colorFactoryBean");
        System.out.println("bean类型：" + colorFactoryBean.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }
}
