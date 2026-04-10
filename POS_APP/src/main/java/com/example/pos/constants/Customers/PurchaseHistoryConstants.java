package com.example.pos.constants.Customers;

/**
 * Class PurchaseHistoryConstants
 *
 * @package com.example.pos.constants.Customers
 *
 * Provides constant values for PurchaseHistory domain.
 */
public final class PurchaseHistoryConstants {

    /**
     * Prevent class instantiation.
     */
    private PurchaseHistoryConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "PurchaseHistory created successfully";
    public static final String MSG_UPDATED_SUCCESS = "PurchaseHistory updated successfully";
    public static final String MSG_DELETED_SUCCESS = "PurchaseHistory deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "PurchaseHistory not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for PurchaseHistory";

}
