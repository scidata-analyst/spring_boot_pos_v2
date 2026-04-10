package com.example.pos.constants.Hardware;

/**
 * Class CashDrawerConstants
 *
 * @package com.example.pos.constants.Hardware
 *
 * Provides constant values for CashDrawer domain.
 */
public final class CashDrawerConstants {

    /**
     * Prevent class instantiation.
     */
    private CashDrawerConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "CashDrawer created successfully";
    public static final String MSG_UPDATED_SUCCESS = "CashDrawer updated successfully";
    public static final String MSG_DELETED_SUCCESS = "CashDrawer deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "CashDrawer not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for CashDrawer";

}
