package com.sunbc.condition;

import com.sunbc.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.sunbc.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.sunbc.bean.Blue");
        if (red && blue){
            RootBeanDefinition definition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow",definition);
        }
    }
}
