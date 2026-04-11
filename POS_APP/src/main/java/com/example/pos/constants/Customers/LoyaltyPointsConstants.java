package com.example.pos.constants.Customers;

/**
 * Class LoyaltyPointsConstants
 *
 * @package com.example.pos.constants.Customers
 *
 *          Provides constant values for LoyaltyPoints domain.
 */
public final class LoyaltyPointsConstants {

    /**
     * Prevent class instantiation.
     */
    private LoyaltyPointsConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "LoyaltyPoints created successfully";
    public static final String MSG_UPDATED_SUCCESS = "LoyaltyPoints updated successfully";
    public static final String MSG_DELETED_SUCCESS = "LoyaltyPoints deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "LoyaltyPoints not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for LoyaltyPoints";

}
