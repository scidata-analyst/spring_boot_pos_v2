package com.example.pos.middlewares.filters.Products;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * HTTP filter for BatchExpiry module.
 * Handles request pre-processing tasks like logging or authentication.
 */
@Component
public class BatchExpiryFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(""Filter applied for BatchExpiry: "" + request.getRequestURI());
        chain.doFilter(request, response);
    }
}
