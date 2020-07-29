package com.sunbc.tomcat.impl;

import com.sunbc.servlet.NettyRequest;
import com.sunbc.servlet.NettyResponse;
import com.sunbc.servlet.Servnet;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class DefaultServnet extends Servnet {

    // http://localhost:8888/someservlet/ad/ad
    @Override
    public void doGet(NettyRequest request, NettyResponse response) throws Exception {
        // 获取到servlet的名称
        String servletName = request.getUri().split("/")[1];
        // 构建一个异常信息
        String content = "404 - not this Servlet: " + servletName;
        // 将异常信息返回到客户端
        response.write(content);
    }

    @Override
    public void doPost(NettyRequest request, NettyResponse response) throws Exception {
        doGet(request,response);
    }
}
