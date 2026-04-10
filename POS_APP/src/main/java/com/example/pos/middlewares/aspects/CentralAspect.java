package com.example.pos.middlewares.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Central AOP aspect for all controllers.
 * Applies cross-cutting concerns like logging, metrics, or exception handling.
 */
@Aspect
@Component
public class CentralAspect {

    @Before("execution(* com.example.pos.controllers..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("Central AOP Before Controller: " + joinPoint.getSignature());
    }
}
