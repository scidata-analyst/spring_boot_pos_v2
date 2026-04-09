package com.example.pos.middlewares.aspects.Products;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Barcodes module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class BarcodesAspect {

    @Before(""execution(* com.example.pos.controllers.Products..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (Barcodes): "" + joinPoint.getSignature());
    }
}
