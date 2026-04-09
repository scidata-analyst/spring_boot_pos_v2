package com.example.pos.middlewares.interceptors.Users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for Roles module.
 * Handles pre/post-processing for controller requests.
 */
@Component
public class RolesInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(""Interceptor preHandle for Roles: "" + request.getRequestURI());
        return true;
    }
}
