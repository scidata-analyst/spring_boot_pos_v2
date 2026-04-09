package com.example.pos.middlewares.aspects.Users;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Roles module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class RolesAspect {

    @Before(""execution(* com.example.pos.controllers.Users..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (Roles): "" + joinPoint.getSignature());
    }
}
