package com.example.pos.middlewares.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Central HTTP filter for all requests.
 * Handles logging, authentication, headers, or request validation.
 */
@Component
public class CentralFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Central Filter applied for: " + ((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }
}
