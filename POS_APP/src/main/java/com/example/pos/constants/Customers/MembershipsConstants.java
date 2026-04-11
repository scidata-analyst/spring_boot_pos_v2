package com.example.pos.constants.Customers;

/**
 * Class MembershipsConstants
 *
 * @package com.example.pos.constants.Customers
 *
 *          Provides constant values for Memberships domain.
 */
public final class MembershipsConstants {

    /**
     * Prevent class instantiation.
     */
    private MembershipsConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Memberships created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Memberships updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Memberships deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Memberships not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Memberships";

}
