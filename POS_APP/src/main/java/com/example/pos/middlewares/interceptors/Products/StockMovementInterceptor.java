package com.example.pos.middlewares.interceptors.Products;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for StockMovement module.
 * Handles pre/post-processing for controller requests.
 */
@Component
public class StockMovementInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Interceptor preHandle for StockMovement: " + request.getRequestURI());
        return true;
    }
}
