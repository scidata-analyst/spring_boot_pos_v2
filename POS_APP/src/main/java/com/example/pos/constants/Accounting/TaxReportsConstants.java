package com.example.pos.constants.Accounting;

/**
 * Class TaxReportsConstants
 *
 * @package com.example.pos.constants.Accounting
 *
 * Provides constant values for TaxReports domain.
 */
public final class TaxReportsConstants {

    /**
     * Prevent class instantiation.
     */
    private TaxReportsConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "TaxReports created successfully";
    public static final String MSG_UPDATED_SUCCESS = "TaxReports updated successfully";
    public static final String MSG_DELETED_SUCCESS = "TaxReports deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "TaxReports not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for TaxReports";

}
