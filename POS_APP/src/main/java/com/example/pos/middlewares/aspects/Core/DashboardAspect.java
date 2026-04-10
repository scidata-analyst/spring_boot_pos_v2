package com.example.pos.middlewares.aspects.Core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Dashboard module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class DashboardAspect {

    @Before("execution(* com.example.pos.controllers.Core..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (Dashboard): " + joinPoint.getSignature());
    }
}
