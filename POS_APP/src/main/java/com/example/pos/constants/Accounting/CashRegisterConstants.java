package com.example.pos.constants.Accounting;

/**
 * Class CashRegisterConstants
 *
 * @package com.example.pos.constants.Accounting
 *
 * Provides constant values for CashRegister domain.
 */
public final class CashRegisterConstants {

    /**
     * Prevent class instantiation.
     */
    private CashRegisterConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "CashRegister created successfully";
    public static final String MSG_UPDATED_SUCCESS = "CashRegister updated successfully";
    public static final String MSG_DELETED_SUCCESS = "CashRegister deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "CashRegister not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for CashRegister";

}
