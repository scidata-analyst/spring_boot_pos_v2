package com.example.pos.middlewares.aspects.Reports;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for SalesReport module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class SalesReportAspect {

    @Before("execution(* com.example.pos.controllers.Reports..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (SalesReport): " + joinPoint.getSignature());
    }
}
