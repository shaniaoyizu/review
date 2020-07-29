package com.sunbc.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created on 2020-07-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeClientHandler extends ChannelInboundHandlerAdapter {

    private String message = "Hello world";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.channel().writeAndFlush(message);
//        ctx.channel().writeAndFlush(message);

        byte[] bytes = message.getBytes();
        ByteBuf buffer = null;
        for (int i = 0; i < 100; i++) {
            // 申请缓存空间
            buffer = Unpooled.buffer(message.getBytes().length);
            // 将数据写入到缓存空间
            buffer.writeBytes(bytes);
            // 将缓存中的数据写入到Channel
            ctx.writeAndFlush(buffer);
        }

//        for (int i = 0; i < 100; i++) {
//            ctx.writeAndFlush(message);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
