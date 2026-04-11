package com.example.pos.constants.Reports;

/**
 * Class SalesReportConstants
 *
 * @package com.example.pos.constants.Reports
 *
 *          Provides constant values for SalesReport domain.
 */
public final class SalesReportConstants {

    /**
     * Prevent class instantiation.
     */
    private SalesReportConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "SalesReport created successfully";
    public static final String MSG_UPDATED_SUCCESS = "SalesReport updated successfully";
    public static final String MSG_DELETED_SUCCESS = "SalesReport deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "SalesReport not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for SalesReport";

}
