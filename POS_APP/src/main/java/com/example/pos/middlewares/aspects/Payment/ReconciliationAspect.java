package com.example.pos.middlewares.aspects.Payment;

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

    @Before("execution(* com.example.pos.controllers.Payment..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (Reconciliation): " + joinPoint.getSignature());
    }
}
