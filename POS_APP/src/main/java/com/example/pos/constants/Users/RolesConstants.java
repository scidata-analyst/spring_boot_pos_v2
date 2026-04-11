package com.example.pos.constants.Users;

/**
 * Class RolesConstants
 *
 * @package com.example.pos.constants.Users
 *
 *          Provides constant values for Roles domain.
 */
public final class RolesConstants {

    /**
     * Prevent class instantiation.
     */
    private RolesConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Roles created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Roles updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Roles deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Roles not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Roles";

}
