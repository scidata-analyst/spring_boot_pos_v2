package com.example.pos.middlewares.aspects.Loyalty;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for TierManagement module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class TierManagementAspect {

    @Before("execution(* com.example.pos.controllers.Loyalty..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (TierManagement): " + joinPoint.getSignature());
    }
}
