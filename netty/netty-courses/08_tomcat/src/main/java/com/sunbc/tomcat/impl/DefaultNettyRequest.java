package com.sunbc.tomcat.impl;

import com.sunbc.servlet.NettyRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class DefaultNettyRequest implements NettyRequest {

    private HttpRequest request;

    public DefaultNettyRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String getUri() {
        return request.uri();
    }

    @Override
    public String getMethod() {
        return request.method().name();
    }

    @Override
    public Map<String, List<String>> getParameters() {
        return new QueryStringDecoder(request.uri()).parameters();
    }

    @Override
    public List<String> getParameters(String name) {
        return this.getParameters().get(name);
    }

    @Override
    public String getParameter(String name) {
        List<String> parameters = this.getParameters(name);
        return (parameters == null || parameters.size() == 0) ? null : parameters.get(0);
    }

    @Override
    public String getPath() {
        return new QueryStringDecoder(request.uri()).path();
    }
}
