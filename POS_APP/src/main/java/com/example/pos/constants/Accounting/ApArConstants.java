package com.example.pos.constants.Accounting;

/**
 * Class ApArConstants
 *
 * @package com.example.pos.constants.Accounting
 *
 *          Provides constant values for ApAr domain.
 */
public final class ApArConstants {

    /**
     * Prevent class instantiation.
     */
    private ApArConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "ApAr created successfully";
    public static final String MSG_UPDATED_SUCCESS = "ApAr updated successfully";
    public static final String MSG_DELETED_SUCCESS = "ApAr deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "ApAr not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for ApAr";

}
