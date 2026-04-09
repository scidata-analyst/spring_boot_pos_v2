package com.example.pos.middlewares.aspects.Sales;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Invoices module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class InvoicesAspect {

    @Before(""execution(* com.example.pos.controllers.Sales..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (Invoices): "" + joinPoint.getSignature());
    }
}
