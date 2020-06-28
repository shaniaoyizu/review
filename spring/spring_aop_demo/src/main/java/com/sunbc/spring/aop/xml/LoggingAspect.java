package com.sunbc.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("beforeMethod: The method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterMethod: The method " + methodName + " ends");
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterReturning: The method " + methodName + " ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterThrowing: The method " + methodName + " occurs exception: " + ex);
    }

    public Object aroundMethod(ProceedingJoinPoint point){
        String methodName = point.getSignature().getName();
        Object result = null;
        System.out.println("aroundMethod: The method " + methodName + " begins with " + Arrays.asList(point.getArgs()));
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aroundMethod: The method " + methodName + " ends with " + result);
        return result;
    }
}
