package com.sunbc.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * Created on 2020-07-25
 * 管道初始化器
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeChannelInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 当Channel初始化创建完毕之后就会触发该方法的执行，用于初始化Channel
     * @param ch
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 从Channel中获取pipeline
        ChannelPipeline pipeline = ch.pipeline();
        // 将HttpServerCodec放到pipeline的最后
        pipeline.addLast(new HttpServerCodec());
        // 将自定义的处理器放入到pipeline的最后
        pipeline.addLast(new SomeServerHandler());
    }
}
