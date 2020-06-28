package com.sunbc.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * Created on 2020-06-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args = {java.sql.Statement.class})})
public class MyFirstPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin...intercept..." + invocation.getMethod());
        Object target = invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数是："+value);
        metaObject.setValue("parameterHandler.parameterObject",2);
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin...plugin...mybatis将要包装的对象：" + target);
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("输出属性：" + properties);
    }
}
