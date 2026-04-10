package com.example.pos.middlewares.interceptors.Promos;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for Offers module.
 * Handles pre/post-processing for controller requests.
 */
@Component
public class OffersInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Interceptor preHandle for Offers: " + request.getRequestURI());
        return true;
    }
}
