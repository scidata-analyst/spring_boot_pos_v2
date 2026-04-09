package com.example.pos.middlewares.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Centralized rate limiter filter for the application.
 * <p>
 * Limits the number of requests per client IP within a fixed time window.
 * Returns HTTP 429 (Too Many Requests) if the limit is exceeded.
 * <p>
 * Default configuration: 100 requests per 1-minute window.
 * This filter is applied globally to all incoming HTTP requests.
 */
@Component
public class RateLimiterFilter extends HttpFilter {

    /** Tracks request counts per client IP */
    private final Map<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    /** Tracks the start timestamp of each client's time window */
    private final Map<String, Long> timestamps = new ConcurrentHashMap<>();

    /** Maximum requests allowed per client within the window */
    private final int MAX_REQUESTS = 100;

    /** Duration of time window in milliseconds (1 minute) */
    private final long WINDOW_MS = 60000;

    /**
     * Processes each incoming HTTP request.
     * <p>
     * Increments the request count for the client IP and checks the limit.
     * If the limit is exceeded, returns HTTP 429.
     * Otherwise, continues the request chain.
     *
     * @param request  the incoming HTTP request
     * @param response the HTTP response
     * @param chain    the filter chain
     * @throws IOException      if an input/output error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        String clientIP = request.getRemoteAddr();
        long now = System.currentTimeMillis();

        timestamps.putIfAbsent(clientIP, now);
        requestCounts.putIfAbsent(clientIP, new AtomicInteger(0));

        // Reset counter if time window expired
        if (now - timestamps.get(clientIP) > WINDOW_MS) {
            timestamps.put(clientIP, now);
            requestCounts.get(clientIP).set(0);
        }

        // Exceeding requests returns 429
        if (requestCounts.get(clientIP).incrementAndGet() > MAX_REQUESTS) {
            response.setStatus(HttpServletResponse.SC_TOO_MANY_REQUESTS);
            response.getWriter().write("Too many requests. Please try again later.");
            return;
        }

        // Proceed with request
        chain.doFilter(request, response);
    }
}
