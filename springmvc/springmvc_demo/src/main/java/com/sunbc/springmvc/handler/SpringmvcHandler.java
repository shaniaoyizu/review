package com.sunbc.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020-07-01
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Controller
public class SpringmvcHandler {

    @RequestMapping(value = "testRequestMappingParamsAndHeaders", params = {"username", "age=22"}, headers = {"Accept-Language"})
    public String testRequestMappingParamsAndHeaders() {
        return "success";
    }

    @RequestMapping(value = "testRequestMappingMethod", method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMappingMethod() {
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        System.out.println(name + ":" + id);
        return "success";
    }

    @RequestMapping(value = "order/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id) {
        System.out.println("GET:" + id);
        return "success";
    }

    @RequestMapping(value = "order/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("delete:" + id);
        return "redirect:/success";
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("REST POST");
        return "success";
    }

    @RequestMapping(value = "order", method = RequestMethod.PUT)
    public String testRestPut() {
        System.out.println("REST PUT");
        return "redirect:/success";
    }

    @RequestMapping(value = "success")
    public String success(){
        return "success";
    }

    @RequestMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request: " + request);
        System.out.println("response: " + response);
//        request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request,response);
//        response.sendRedirect("http://www.baidu.com");
        response.getWriter().println("Hello SpringMVC");
    }
}
