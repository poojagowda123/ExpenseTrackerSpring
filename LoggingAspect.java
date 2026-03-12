package com.expensetracker.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Runs before DAO method
    @Before("execution(* com.expensetracker.dao.*.*(..))")
    public void beforeDao(JoinPoint jp) {
        System.out.println("AOP BEFORE: " + jp.getSignature().getName());
    }

    // Runs after DAO method
    @After("execution(* com.expensetracker.dao.*.*(..))")
    public void afterDao(JoinPoint jp) {
        System.out.println("AOP AFTER: " + jp.getSignature().getName());
    }

    // Runs after successful execution
    @AfterReturning("execution(* com.expensetracker.dao.*.*(..))")
    public void successDao(JoinPoint jp) {
        System.out.println("AOP SUCCESS: " + jp.getSignature().getName());
    }

    // Runs if error happens
    @AfterThrowing("execution(* com.expensetracker.dao.*.*(..))")
    public void errorDao(JoinPoint jp) {
        System.out.println("AOP ERROR in: " + jp.getSignature().getName());
    }
}