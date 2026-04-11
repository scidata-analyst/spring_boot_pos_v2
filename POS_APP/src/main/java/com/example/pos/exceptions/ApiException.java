package com.example.pos.exceptions;

/**
 * Base custom exception for API-related errors.
 * <p>
 * Extend this exception for specific API error types.
 */
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
