package com.example.pos.middlewares.aspects.Promos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Coupons module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class CouponsAspect {

    @Before(""execution(* com.example.pos.controllers.Promos..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (Coupons): "" + joinPoint.getSignature());
    }
}
