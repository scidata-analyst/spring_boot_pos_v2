package com.example.pos.middlewares.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * =====================================================
 * Request Logging Filter
 * =====================================================
 *
 * Purpose:
 * - Logs every incoming HTTP request
 * - Used for debugging & audit tracking
 *
 * Execution Level:
 * - Runs before controller execution
 */
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("[FILTER] Request URI: " + request.getRequestURI());
        System.out.println("[FILTER] Method: " + request.getMethod());

        filterChain.doFilter(request, response);
    }
}
