package com.example.pos.middlewares.aspects.Customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for LoyaltyPoints module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class LoyaltyPointsAspect {

    @Before("execution(* com.example.pos.controllers.Customers..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (LoyaltyPoints): " + joinPoint.getSignature());
    }
}
