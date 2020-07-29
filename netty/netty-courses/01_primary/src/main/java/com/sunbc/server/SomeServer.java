package com.sunbc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

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
        // 用于处理客户端连接请求，将请求发送给childGroup中的eventLoop
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        // 用于处理客户端请求
        EventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            // 用于启动ServerChannel
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup) //指定eventLoopGroup
                    .channel(NioServerSocketChannel.class)  // 指定使用NIO进行通信
                    .childHandler(new SomeChannelInitializer());  // 指定处理器childGroup中的eventGroup所绑定的线程所要处理的处理器

            // 指定当前服务器所监听的端口号
            // bind()方法的执行时异步的
            // sync()方法会使bind()操作与后续额代码的执行由异步变成了同步
            ChannelFuture future = bootstrap.bind(8888).sync();
            System.out.println("服务器启动成功。监听的端口为：8888");
            // 关闭Channel
            // closeFuture()的执行是异步的
            // 当Channel调用了close()方法并关闭成功后才会触发closeFuture方法的执行
            future.channel().closeFuture().sync();
        } finally {
            // 优雅地关闭
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
