package com.sunbc.restful.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
