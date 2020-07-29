package com.sunbc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created on 2020-07-25
 *
 * 服务器启动类
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                    /**
                    * 当Channel初始化创建完毕之后就会触发该方法的执行，用于初始化Channel
                    * @param ch
                    * @throws Exception
                    */
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new HttpServerCodec());
                        // 添加大块数据Chunk处理器
                        pipeline.addLast(new ChunkedWriteHandler());
                        // 添加Chunk聚合处理器
                        pipeline.addLast(new HttpObjectAggregator(4096));
                        // 添加WebSocket协议转化处理器
                        pipeline.addLast(new WebSocketServerProtocolHandler("/some"));
                        pipeline.addLast(new SomeServerHandler());
                    }
                });

            ChannelFuture future = bootstrap.bind(8888).sync();
            System.out.println("服务器启动成功。监听的端口为：8888");
            future.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}