package com.example.pos.middlewares.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Central interceptor for all controller requests.
 * Handles pre/post-processing like logging or metrics.
 */
@Component
public class CentralInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(""Central Interceptor preHandle: "" + request.getRequestURI());
        return true;
    }
}
