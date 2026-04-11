package com.example.pos.constants.Promos;

/**
 * Class OffersConstants
 *
 * @package com.example.pos.constants.Promos
 *
 *          Provides constant values for Offers domain.
 */
public final class OffersConstants {

    /**
     * Prevent class instantiation.
     */
    private OffersConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "Offers created successfully";
    public static final String MSG_UPDATED_SUCCESS = "Offers updated successfully";
    public static final String MSG_DELETED_SUCCESS = "Offers deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "Offers not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for Offers";

}
