package com.example.pos.middlewares.interceptors.Hardware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for QrMobile module.
 * Handles pre/post-processing for controller requests.
 */
@Component
public class QrMobileInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(""Interceptor preHandle for QrMobile: "" + request.getRequestURI());
        return true;
    }
}
