package com.example.pos.constants.Users;

/**
 * Class CashiersConstants
 *
 * @package com.example.pos.constants.Users
 *
 *          Provides constant values for Cashiers domain.
 */
public final class CashiersConstants {

    /**
     * Prevent class instantiation.
     */
    private CashiersConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Cashiers created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Cashiers updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Cashiers deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Cashiers not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Cashiers";

}
