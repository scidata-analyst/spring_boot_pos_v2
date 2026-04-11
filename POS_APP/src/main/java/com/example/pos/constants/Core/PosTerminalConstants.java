package com.example.pos.constants.Core;

/**
 * Class PosTerminalConstants
 *
 * @package com.example.pos.constants.Core
 *
 *          Provides constant values for PosTerminal domain.
 */
public final class PosTerminalConstants {

    /**
     * Prevent class instantiation.
     */
    private PosTerminalConstants() {
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
    public static final String MSG_CREATED_SUCCESS = "PosTerminal created successfully";
    public static final String MSG_UPDATED_SUCCESS = "PosTerminal updated successfully";
    public static final String MSG_DELETED_SUCCESS = "PosTerminal deleted successfully";

    /**
     * Error messages
     */
    public static final String ERR_NOT_FOUND = "PosTerminal not found";
    public static final String ERR_INVALID_REQUEST = "Invalid request for PosTerminal";

}
