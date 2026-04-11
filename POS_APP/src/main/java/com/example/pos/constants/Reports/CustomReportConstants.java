package com.example.pos.constants.Reports;

/**
 * Class CustomReportConstants
 *
 * @package com.example.pos.constants.Reports
 *
 *          Provides constant values for CustomReport domain.
 */
public final class CustomReportConstants {

    /**
     * Prevent class instantiation.
     */
    private CustomReportConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "CustomReport created successfully";
    public static final String MSG_UPDATED_SUCCESS = "CustomReport updated successfully";
    public static final String MSG_DELETED_SUCCESS = "CustomReport deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "CustomReport not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for CustomReport";

}
