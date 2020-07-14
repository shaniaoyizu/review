package com.sunbc;

import com.sunbc.config.MyConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestLifeCycle {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        applicationContext.close();
    }
}
