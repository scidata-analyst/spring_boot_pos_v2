package com.example.pos.middlewares.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Central HTTP filter for all requests.
 * Handles logging, authentication, headers, or request validation.
 */
@Component
public class CentralFilter extends HttpFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Central Filter applied for: " + request.getRequestURI());
        chain.doFilter(request, response);
    }
}
