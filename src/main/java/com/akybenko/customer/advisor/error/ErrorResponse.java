package com.akybenko.customer.advisor.error;

import java.util.Date;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class ErrorResponse {

    private final Date timestamp = new Date();
    private final int status;
    private final String error;
    private final String path;
}
