package com.example.pos.utils.core;

/**
 * Utility class for common validations.
 */
public class ValidationUtils {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
