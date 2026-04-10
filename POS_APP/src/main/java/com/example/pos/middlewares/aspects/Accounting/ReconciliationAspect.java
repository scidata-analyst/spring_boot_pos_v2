package com.example.pos.middlewares.aspects.Accounting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Reconciliation module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class ReconciliationAspect {

    @Before("execution(* com.example.pos.controllers.Accounting..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (Reconciliation): " + joinPoint.getSignature());
    }
}
