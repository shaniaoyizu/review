package com.sunbc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    private GenericFutureListener listener;
    private ScheduledFuture<?> schedule;

    private Bootstrap bootstrap;

    public HeartBeatHandler(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        randomSend(ctx.channel());
    }

    private void randomSend(Channel channel){
        int heartBeatInterval = new Random().nextInt(7) + 1;
        System.out.println(heartBeatInterval + "秒后发送下一个心跳");

        // 为eventLoop添加一个异步定时任务---heartBeatInterval后发送心跳
        schedule = channel.eventLoop().schedule(() -> {
            if (channel.isActive()){
                System.out.println("向服务端发送心跳");
                channel.writeAndFlush("~PING~");
            }else {
                System.out.println("与服务器连接已断开");
            }
        },heartBeatInterval, TimeUnit.SECONDS);

        // 定义监听器
        listener = future -> randomSend(channel);

        // 为异步定时任务添加监听器
        schedule.addListener(listener);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        schedule.removeListener(listener);

        System.out.println("Reconnecting...");

        //重试
        bootstrap.connect("localhost",8888).sync();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
