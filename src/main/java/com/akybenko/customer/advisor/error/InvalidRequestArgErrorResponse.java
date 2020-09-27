package com.akybenko.customer.advisor.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvalidRequestArgErrorResponse {

    private String arg;
    private String message;
}
