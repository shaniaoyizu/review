package com.sunbc.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ArithmeticCalculatorLoggingProxy {

    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = (ArithmeticCalculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{ArithmeticCalculator.class},
                (p, method, args) -> {
                    String methodName = method.getName();
                    System.out.println("The method " + methodName + " begin with " + Arrays.asList(args));
                    Object result = method.invoke(target, args);
                    System.out.println("The method " + methodName + " ends with " + result);
                    return result;
                });
        return proxy;
    }
}
