package com.sunbc.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RpcClientHandler extends SimpleChannelInboundHandler<Object> {

    private Object result;

    public Object getResult() {
        return result;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
