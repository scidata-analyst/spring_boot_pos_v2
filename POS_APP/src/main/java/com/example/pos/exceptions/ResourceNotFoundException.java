package com.example.pos.exceptions;

/**
 * Exception thrown when a requested resource/entity is not found.
 * Typically used for CRUD operations.
 */
public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Resource '%s' not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
