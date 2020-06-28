package com.sunbc.beans.processor;

import com.sunbc.beans.cycle.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + bean + "," + beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + bean + "," + beanName);
        return bean;
    }
}
