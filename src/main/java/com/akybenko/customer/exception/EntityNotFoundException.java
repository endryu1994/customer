package com.akybenko.customer.exception;

import static com.akybenko.customer.constant.ErrorMessage.ENTITY_NOT_FOUND_REASON;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = NOT_FOUND, reason = ENTITY_NOT_FOUND_REASON)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
