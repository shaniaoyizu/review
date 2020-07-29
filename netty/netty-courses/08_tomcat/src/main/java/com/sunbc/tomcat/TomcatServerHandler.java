package com.sunbc.tomcat;

import com.sunbc.servlet.Servnet;
import com.sunbc.tomcat.impl.DefaultServnet;
import com.sunbc.tomcat.impl.DefaultNettyRequest;
import com.sunbc.tomcat.impl.DefaultNettyResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

import java.util.Map;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TomcatServerHandler extends ChannelInboundHandlerAdapter {

    private Map<String, String> classNameMap;
    private Map<String,Servnet> instanceMap;

    public TomcatServerHandler(Map<String, String> classNameMap, Map<String,Servnet> instanceMap) {
        this.classNameMap = classNameMap;
        this.instanceMap = instanceMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            String servnetName = request.uri().split("/")[1];
            Servnet servnet;
            // 若注册表中存在指定的servnet，则获取该Servnet实现，否则获取默认Servnet实例
            if (instanceMap.containsKey(servnetName)) {
                servnet = instanceMap.get(servnetName);
            } else if (classNameMap.containsKey(servnetName)){
                String className = classNameMap.get(servnetName);
                servnet = (Servnet) Class.forName(className).newInstance();
                instanceMap.put(servnetName,servnet);
            }else {
                servnet = new DefaultServnet();
            }

            DefaultNettyRequest req = new DefaultNettyRequest(request);
            DefaultNettyResponse res = new DefaultNettyResponse(request, ctx);

            if (request.method().name().equalsIgnoreCase("GET")) {
                servnet.doGet(req, res);
            } else if (request.method().name().equalsIgnoreCase("POST")) {
                servnet.doPost(req, res);
            }
        }
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
