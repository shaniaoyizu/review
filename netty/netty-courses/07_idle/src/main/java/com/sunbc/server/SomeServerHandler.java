package com.sunbc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created on 2020-07-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 所有“规定动作”之外的所有事件都可以通过以下方法触发
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventDes = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventDes = "读空闲超时";
                    break;
                case WRITER_IDLE:
                    eventDes = "写空闲超时";
                    break;
                case ALL_IDLE:
                    eventDes = "读和写空闲超时";
                    break;
            }
            System.out.println(eventDes);
//            ctx.close();
        } else {
            // 其他事件触发
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
