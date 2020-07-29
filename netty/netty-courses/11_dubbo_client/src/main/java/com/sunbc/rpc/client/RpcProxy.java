package com.sunbc.rpc.client;

import com.sunbc.rpc.discovery.ServiceDiscovery;
import com.sunbc.rpc.discovery.ServiceDiscoveryImpl;
import com.sunbc.rpc.dto.Invocation;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RpcProxy {
    public static <T> T create(Class<?> clazz, String prefix) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 若调用的是Object的方法，则直接进行本地调用
                        if (Object.class.equals(method.getDeclaringClass())) {
                            return method.invoke(this, args);
                        }
                        // 远程调用
                        return rpcInvoke(clazz, method, args, prefix);
                    }
                });
    }

    private static Object rpcInvoke(Class<?> clazz, Method method, Object[] args, String prefix) throws Exception {
        ServiceDiscovery discovery = new ServiceDiscoveryImpl();
        String invoker = discovery.discovery(clazz.getName());
        if (invoker == null) {
            return null;
        }

        RpcClientHandler handler = new RpcClientHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(handler);
                        }
                    });
            String ip = invoker.split(":")[0];
            String portStr = invoker.split(":")[1];
            Integer port = Integer.valueOf(portStr);

            ChannelFuture future = bootstrap.connect(ip, port).sync();
            Invocation invocation = new Invocation();
            invocation.setClassName(clazz.getName());
            invocation.setMethodName(method.getName());
            invocation.setParamTypes(method.getParameterTypes());
            invocation.setParamValue(args);
            invocation.setPrefix(prefix);
            future.channel().writeAndFlush(invocation).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
        return handler.getResult();
    }
}
