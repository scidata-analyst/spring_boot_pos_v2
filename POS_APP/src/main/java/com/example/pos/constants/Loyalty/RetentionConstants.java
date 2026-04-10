package com.example.pos.constants.Loyalty;

/**
 * Class RetentionConstants
 *
 * @package com.example.pos.constants.Loyalty
 *
 * Provides constant values for Retention domain.
 */
public final class RetentionConstants {

    /**
     * Prevent class instantiation.
     */
    private RetentionConstants() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Status values
     */
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";

    /**
     * Pagination defaults
     */
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;

    /**
     * Success messages
     */
    public static final String MSG_CREATED_SUCCESS = "Retention created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Retention updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Retention deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Retention not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Retention";

}
