package com.sunbc.servlet;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public abstract class Servnet {

    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public abstract void doGet(NettyRequest request, NettyResponse response) throws Exception;

    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public abstract void doPost(NettyRequest request, NettyResponse response) throws Exception;
}
