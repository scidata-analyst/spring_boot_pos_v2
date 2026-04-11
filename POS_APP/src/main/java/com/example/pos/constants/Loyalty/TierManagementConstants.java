package com.example.pos.constants.Loyalty;

/**
 * Class TierManagementConstants
 *
 * @package com.example.pos.constants.Loyalty
 *
 *          Provides constant values for TierManagement domain.
 */
public final class TierManagementConstants {

    /**
     * Prevent class instantiation.
     */
    private TierManagementConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "TierManagement created successfully";
    public static final String MSG_UPDATED_SUCCESS = "TierManagement updated successfully";
    public static final String MSG_DELETED_SUCCESS = "TierManagement deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "TierManagement not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for TierManagement";

}
