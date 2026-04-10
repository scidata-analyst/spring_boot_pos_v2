package com.example.pos.middlewares.aspects.Accounting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for TaxReports module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class TaxReportsAspect {

    @Before("execution(* com.example.pos.controllers.Accounting..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (TaxReports): " + joinPoint.getSignature());
    }
}
