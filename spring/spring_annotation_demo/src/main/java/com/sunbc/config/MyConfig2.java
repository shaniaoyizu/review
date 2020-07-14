package com.sunbc.config;

import com.sunbc.bean.Color;
import com.sunbc.bean.ColorFactoryBean;
import com.sunbc.bean.Person;
import com.sunbc.bean.Red;
import com.sunbc.condition.LinuxCondition;
import com.sunbc.condition.MyBeanDefinitionRegistrar;
import com.sunbc.condition.MyImportSelector;
import com.sunbc.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Conditional(WindowsCondition.class)
@Import({Color.class, Red.class, MyImportSelector.class, MyBeanDefinitionRegistrar.class})
@Configuration
public class MyConfig2 {

    @Bean("person")
    public Person person() {
        return new Person("张三", 20);
    }

    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 70);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("Linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
