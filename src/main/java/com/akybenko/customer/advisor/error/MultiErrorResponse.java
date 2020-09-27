package com.akybenko.customer.advisor.error;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MultiErrorResponse extends ErrorResponse {

    private final Collection<InvalidRequestArgErrorResponse> errors;
}
