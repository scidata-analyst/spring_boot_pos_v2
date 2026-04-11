package com.example.pos.constants.Accounting;

/**
 * Class ReconciliationConstants
 *
 * @package com.example.pos.constants.Accounting
 *
 *          Provides constant values for Reconciliation domain.
 */
public final class ReconciliationConstants {

    /**
     * Prevent class instantiation.
     */
    private ReconciliationConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Reconciliation created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Reconciliation updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Reconciliation deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Reconciliation not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Reconciliation";

}
