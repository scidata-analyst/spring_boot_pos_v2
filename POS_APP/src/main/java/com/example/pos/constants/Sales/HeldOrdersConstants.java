package com.example.pos.constants.Sales;

/**
 * Class HeldOrdersConstants
 *
 * @package com.example.pos.constants.Sales
 *
 * Provides constant values for HeldOrders domain.
 */
public final class HeldOrdersConstants {

    /**
     * Prevent class instantiation.
     */
    private HeldOrdersConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "HeldOrders created successfully";
    public static final String MSG_UPDATED_SUCCESS = "HeldOrders updated successfully";
    public static final String MSG_DELETED_SUCCESS = "HeldOrders deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "HeldOrders not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for HeldOrders";

}
