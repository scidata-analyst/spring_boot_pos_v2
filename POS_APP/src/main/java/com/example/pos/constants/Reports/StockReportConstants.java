package com.example.pos.constants.Reports;

/**
 * Class StockReportConstants
 *
 * @package com.example.pos.constants.Reports
 *
 * Provides constant values for StockReport domain.
 */
public final class StockReportConstants {

    /**
     * Prevent class instantiation.
     */
    private StockReportConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "StockReport created successfully";
    public static final String MSG_UPDATED_SUCCESS = "StockReport updated successfully";
    public static final String MSG_DELETED_SUCCESS = "StockReport deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "StockReport not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for StockReport";

}
