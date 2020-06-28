package com.sunbc.spring.aop.impl;

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
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.sunbc.spring.aop.impl.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("beforeMethod: The method " + methodName + " begins with " + args);
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterMethod: The method " + methodName + " ends");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterReturning: The method " + methodName + " ends with " + result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterThrowing: The method " + methodName + " occurs exception: " + ex);
    }

    @Around(value = "pointCut()")
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
