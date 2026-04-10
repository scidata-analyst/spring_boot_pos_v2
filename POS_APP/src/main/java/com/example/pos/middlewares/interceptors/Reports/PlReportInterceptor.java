package com.example.pos.middlewares.interceptors.Reports;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for PlReport module.
 * Handles pre/post-processing for controller requests.
 */
@Component
public class PlReportInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Interceptor preHandle for PlReport: " + request.getRequestURI());
        return true;
    }
}
