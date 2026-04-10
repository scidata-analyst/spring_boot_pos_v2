package com.example.pos.constants.Promos;

/**
 * Class HappyHourConstants
 *
 * @package com.example.pos.constants.Promos
 *
 * Provides constant values for HappyHour domain.
 */
public final class HappyHourConstants {

    /**
     * Prevent class instantiation.
     */
    private HappyHourConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "HappyHour created successfully";
    public static final String MSG_UPDATED_SUCCESS = "HappyHour updated successfully";
    public static final String MSG_DELETED_SUCCESS = "HappyHour deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "HappyHour not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for HappyHour";

}
