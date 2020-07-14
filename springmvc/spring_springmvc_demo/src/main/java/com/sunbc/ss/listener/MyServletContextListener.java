package com.sunbc.ss.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created on 2020-07-02
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("applicationContext",ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
