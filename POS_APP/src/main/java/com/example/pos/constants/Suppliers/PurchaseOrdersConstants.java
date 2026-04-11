package com.example.pos.constants.Suppliers;

/**
 * Class PurchaseOrdersConstants
 *
 * @package com.example.pos.constants.Suppliers
 *
 *          Provides constant values for PurchaseOrders domain.
 */
public final class PurchaseOrdersConstants {

    /**
     * Prevent class instantiation.
     */
    private PurchaseOrdersConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "PurchaseOrders created successfully";
    public static final String MSG_UPDATED_SUCCESS = "PurchaseOrders updated successfully";
    public static final String MSG_DELETED_SUCCESS = "PurchaseOrders deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "PurchaseOrders not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for PurchaseOrders";

}
