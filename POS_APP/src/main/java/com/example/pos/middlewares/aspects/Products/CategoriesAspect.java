package com.example.pos.middlewares.aspects.Products;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for Categories module.
 * Applies cross-cutting concerns like logging, metrics, etc.
 */
@Aspect
@Component
public class CategoriesAspect {

    @Before(""execution(* com.example.pos.controllers.Products..*(..))"")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(""AOP Before Controller (Categories): "" + joinPoint.getSignature());
    }
}
