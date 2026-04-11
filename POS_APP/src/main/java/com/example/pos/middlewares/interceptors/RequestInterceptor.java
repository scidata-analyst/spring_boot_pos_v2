package com.example.pos.middlewares.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * =====================================================
 * Request Interceptor
 * =====================================================
 *
 * Purpose:
 * - Intercepts requests before controller execution
 * - Used for authentication / logging / validation
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        System.out.println("[INTERCEPTOR] PreHandle: " + request.getRequestURI());
        return true; // continue request flow
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) {

        System.out.println("[INTERCEPTOR] PostHandle executed");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {

        System.out.println("[INTERCEPTOR] After Completion");
    }
}
