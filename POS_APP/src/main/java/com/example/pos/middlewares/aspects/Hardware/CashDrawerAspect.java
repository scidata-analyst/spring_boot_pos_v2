package com.example.pos.middlewares.aspects.Hardware;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for CashDrawer module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class CashDrawerAspect {

    @Before("execution(* com.example.pos.controllers.Hardware..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP Before Controller (CashDrawer): " + joinPoint.getSignature());
    }
}
