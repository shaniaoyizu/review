package com.sunbc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created on 2020-09-06
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
public class GrayFilter2 extends ZuulFilter {
    // 定义一个原子布尔变量，确保线程安全
    private AtomicBoolean flag = new AtomicBoolean(true);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 根据布尔变量值的不同，路由到不同的主机，然后再将布尔值取反
        if (flag.get()) {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
            flag.set(false);
        }else {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark","gray-host");
            flag.set(true);
        }
        return null;
    }
}
