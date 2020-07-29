package com.sunbc.webapp;

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
public class ThirdServnet extends Servnet {
    @Override
    public void doGet(NettyRequest request, NettyResponse response) throws Exception {
        String param = request.getParameter("name");
        String uri = request.getUri();
        String method = request.getMethod();
        String path = request.getPath();
        String content = "method = " + method + "\n" + "uri = " + uri + "\n" + "path = " + path + "\n" + "param = " + param;
        response.write(content);
    }

    @Override
    public void doPost(NettyRequest request, NettyResponse response) throws Exception {
        doGet(request, response);
    }
}
