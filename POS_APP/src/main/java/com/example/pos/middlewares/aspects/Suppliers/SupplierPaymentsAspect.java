package com.example.pos.middlewares.aspects.Suppliers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for SupplierPayments module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class SupplierPaymentsAspect {

    @Before(""execution(* com.example.pos.controllers.Suppliers..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (SupplierPayments): "" + joinPoint.getSignature());
    }
}
