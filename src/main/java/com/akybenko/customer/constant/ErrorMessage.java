package com.akybenko.customer.constant;

public interface ErrorMessage {

    String ENTITY_NOT_FOUND = "Failed to found entity with id: ";
    String ENTITY_NOT_FOUND_REASON = "Entity not found";

    String ENTITY_NOT_FOUND_ERROR_MESSAGE = ENTITY_NOT_FOUND + "'{}'";
    String ENTITY_NOT_FOUND_FORMAT = ENTITY_NOT_FOUND + "'%s'";
}
