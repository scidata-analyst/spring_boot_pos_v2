package com.example.pos.utils.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for common date operations.
 */
public class DateUtils {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    public static String formatDate(LocalDate date) {
        if (date == null)
            return "";
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }

    public static LocalDate parseDate(String dateString) {
        if (dateString == null)
            return null;
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }
}
