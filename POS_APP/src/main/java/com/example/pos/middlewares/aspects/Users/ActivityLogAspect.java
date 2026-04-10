package com.example.pos.middlewares.aspects.Users;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for ActivityLog module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class ActivityLogAspect {

    @Before("execution(* com.example.pos.controllers.Users..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (ActivityLog): " + joinPoint.getSignature());
    }
}
