package com.example.pos.middlewares.aspects.Promos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for HappyHour module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class HappyHourAspect {

    @Before("execution(* com.example.pos.controllers.Promos..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (HappyHour): " + joinPoint.getSignature());
    }
}
