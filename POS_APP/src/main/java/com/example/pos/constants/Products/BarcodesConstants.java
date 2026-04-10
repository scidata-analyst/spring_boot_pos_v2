package com.example.pos.constants.Products;

/**
 * Class BarcodesConstants
 *
 * @package com.example.pos.constants.Products
 *
 * Provides constant values for Barcodes domain.
 */
public final class BarcodesConstants {

    /**
     * Prevent class instantiation.
     */
    private BarcodesConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Barcodes created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Barcodes updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Barcodes deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Barcodes not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Barcodes";

}
