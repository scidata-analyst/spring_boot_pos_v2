package com.example.pos.constants.Loyalty;

/**
 * Class PointsConfigConstants
 *
 * @package com.example.pos.constants.Loyalty
 *
 * Provides constant values for PointsConfig domain.
 */
public final class PointsConfigConstants {

    /**
     * Prevent class instantiation.
     */
    private PointsConfigConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "PointsConfig created successfully";
    public static final String MSG_UPDATED_SUCCESS = "PointsConfig updated successfully";
    public static final String MSG_DELETED_SUCCESS = "PointsConfig deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "PointsConfig not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for PointsConfig";

}
