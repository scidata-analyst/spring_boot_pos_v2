package com.example.pos.constants.Products;

/**
 * Class CatalogConstants
 *
 * @package com.example.pos.constants.Products
 *
 * Provides constant values for Catalog domain.
 */
public final class CatalogConstants {

    /**
     * Prevent class instantiation.
     */
    private CatalogConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Catalog created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Catalog updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Catalog deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Catalog not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Catalog";

}
