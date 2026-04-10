package com.example.pos.middlewares.filters.Hardware;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * HTTP filter for CashDrawer module.
 * Handles request pre-processing tasks like logging or authentication.
 */
@Component
public class CashDrawerFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter applied for CashDrawer: " + request.getRequestURI());
        chain.doFilter(request, response);
    }
}
