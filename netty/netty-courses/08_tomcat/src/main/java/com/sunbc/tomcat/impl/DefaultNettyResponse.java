package com.sunbc.tomcat.impl;

import com.sunbc.servlet.NettyResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.util.internal.StringUtil;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class DefaultNettyResponse implements NettyResponse {

    private HttpRequest request;

    private ChannelHandlerContext ctx;

    public DefaultNettyResponse(HttpRequest request, ChannelHandlerContext ctx) {
        this.request = request;
        this.ctx = ctx;
    }

    @Override
    public void write(String content) throws Exception {
        if (StringUtil.isNullOrEmpty(content)){
            return;
        }

        // 创建响应对象
        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes("UTF-8")));
        HttpHeaders headers = response.headers();
        // 设置响应内容类型
        headers.set(HttpHeaderNames.CONTENT_TYPE,"text/json");
        // 设置响应内容长度
        headers.set(HttpHeaderNames.CONTENT_LENGTH,response.content().readableBytes());
        // 设置缓存过期时间
        headers.set(HttpHeaderNames.EXPIRES,0);
        // 若请求使用的是长连接，则设置响应连接也为长连接
        if (HttpUtil.isKeepAlive(request)){
            headers.set(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
        }

        // 将响应写入到channel
        ctx.writeAndFlush(response);
    }
}
