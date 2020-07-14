package com.sunbc.ss.servlet;

import com.sunbc.ss.beans.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020-07-02
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1131922318075683207L;

    public HelloServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        ApplicationContext ctx = (ApplicationContext)sc.getAttribute("applicationContext");
        Person person = ctx.getBean("person", Person.class);
        person.sayHello();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
