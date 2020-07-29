package com.sunbc.servlet;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface NettyRequest {
    /**
     * 获取请求URI，包含请求参数
     * @return
     */
    String getUri();

    /**
     * 获取请求方式（GET、POST等）
     * @return
     */
    String getMethod();

    /**
     * 获取请求参数
     * @return
     */
    Map<String,List<String>> getParameters();

    List<String> getParameters(String name);

    String getParameter(String name);

    /**
     * 获取请求路径，即不包含请求参数的URI
     * @return
     */
    String getPath();
}
