package com.sunbc.tomcat;

import com.sunbc.servlet.Servnet;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Registry {
    // 加载并缓存指定包中所有的servlet类名称
    private List<String> servletNameCache = new ArrayList<>();

    // 注册Servlet
    public void registerServlet(String basePackage, Map<String, Object> registerMap) throws Exception {
        // 对指定包中的servlet类名进行缓存
        cacheServletClass(basePackage);

        if (servletNameCache.size() == 0) {
            return;
        }

        for (String className : servletNameCache) {
            Class<?> clazz = Class.forName(className);
            Type superclass = clazz.getGenericSuperclass();
            if (superclass == Servnet.class) {
                // 获取到当前遍历server的全小写字母的简单类名
                String simpleClassName = className.substring(className.lastIndexOf(".") + 1).toLowerCase();
                // 注册Servlet到注册表
                registerMap.put(simpleClassName,clazz.newInstance());
            }
        }
    }

    private void cacheServletClass(String basePackage) {
        URL resource = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        if (resource == null) {
            return;
        }
        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                cacheServletClass(basePackage + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String fileName = file.getName().replaceAll(".class", "").trim();
                servletNameCache.add(basePackage + "." + fileName);
            }
        }
    }
}
