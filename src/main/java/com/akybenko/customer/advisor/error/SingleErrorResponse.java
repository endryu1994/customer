package com.akybenko.customer.advisor.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class SingleErrorResponse extends ErrorResponse {

    private final String message;
}
