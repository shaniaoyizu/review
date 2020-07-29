package com.sunbc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * Created on 2020-07-25
 * <p>
 * 自定义服务端处理器
 * 需求：用户提交一个请求后，在浏览器上就会看到hello netty world
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当Channel中有来自于客户端的数据时就会触发该方法的执行
     *
     * @param ctx 上下文对象
     * @param msg 来自于客户端的信息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String text = ((TextWebSocketFrame) msg).text();
        ctx.channel().writeAndFlush(new TextWebSocketFrame("From Client: " + text));
    }

    /**
     * 当Channel中数据在处理过程中出现异常时会触发该方法的执行
     *
     * @param ctx   上下文
     * @param cause 发生的异常对象
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
