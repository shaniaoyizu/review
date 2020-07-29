package com.sunbc.rpc.server;

import com.sunbc.rpc.dto.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<Invocation> {

    private Map<String,Object> registerMap;

    public RpcServerHandler(Map<String, Object> registerMap) {
        this.registerMap = registerMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Invocation msg) throws Exception {
        Object result = "没有要访问的提供者";

        // 判断注册表中是否存在指定服务
        if (registerMap.containsKey(msg.getClassName())){
            // 获取到相应的提供者实例，然后调用其相应方法
            Object provider = registerMap.get(msg.getClassName());
            result = provider.getClass().getMethod(msg.getMethodName(), msg.getParamTypes())
                    .invoke(provider, msg.getParamValue());
        }
        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
