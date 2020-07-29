package com.sunbc.servlet;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface NettyResponse {

    /**
     * 要将响应内容写入到Channel
     * @param content
     */
    void write(String content) throws Exception;
}
