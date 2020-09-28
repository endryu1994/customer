package com.akybenko.customer.constant;

import java.util.UUID;

public interface Security {

    /**
     * Bean names.
     */
    String USER_SERVICE_BEAN_NAME = "userService";

    /**
     * Disable security user.
     */
    UUID DISABLE_SECURITY_USER_ID = UUID.fromString("7ba77454-f2af-4f83-b4e2-b75e8b0362cb");
    String DISABLE_SECURITY_USERNAME = "Username";
    String DISABLE_SECURITY_FIRST_NAME = "Firstname";
    String DISABLE_SECURITY_LAST_NAME = "Lastname";
    String DISABLE_SECURITY_EMAIL = "email@example.com";
    String DISABLE_SECURITY_ROLES = "ROLE_ADMIN";

    /**
     * Profiles.
     */
    String DEFAULT_PROFILE = "default";
}
