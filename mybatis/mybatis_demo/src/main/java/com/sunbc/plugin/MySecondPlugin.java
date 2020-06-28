package com.sunbc.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Created on 2020-06-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args = {java.sql.Statement.class})})
public class MySecondPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MySecondPlugin...intercept:" + invocation.getMethod());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("MySecondPlugin...plugin:" + target);
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
