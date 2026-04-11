package com.example.pos.constants.Sales;

/**
 * Class ReturnsConstants
 *
 * @package com.example.pos.constants.Sales
 *
 *          Provides constant values for Returns domain.
 */
public final class ReturnsConstants {

    /**
     * Prevent class instantiation.
     */
    private ReturnsConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Returns created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Returns updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Returns deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Returns not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Returns";

}
