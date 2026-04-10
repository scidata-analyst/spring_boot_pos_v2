package com.example.pos.constants.Promos;

/**
 * Class CouponsConstants
 *
 * @package com.example.pos.constants.Promos
 *
 * Provides constant values for Coupons domain.
 */
public final class CouponsConstants {

    /**
     * Prevent class instantiation.
     */
    private CouponsConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Coupons created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Coupons updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Coupons deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Coupons not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Coupons";

}
