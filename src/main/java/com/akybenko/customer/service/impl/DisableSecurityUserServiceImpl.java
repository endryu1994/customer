package com.akybenko.customer.service.impl;

import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_EMAIL;
import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_FIRST_NAME;
import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_LAST_NAME;
import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_ROLES;
import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_USERNAME;
import static com.akybenko.customer.constant.Security.DISABLE_SECURITY_USER_ID;

import java.util.Collections;

import com.akybenko.customer.data.UserInfo;
import com.akybenko.customer.service.UserService;

public class DisableSecurityUserServiceImpl implements UserService {

    @Override
    public UserInfo getUserInfo() {
        return UserInfo.builder()
                .id(DISABLE_SECURITY_USER_ID)
                .username(DISABLE_SECURITY_USERNAME)
                .firstName(DISABLE_SECURITY_FIRST_NAME)
                .lastName(DISABLE_SECURITY_LAST_NAME)
                .email(DISABLE_SECURITY_EMAIL)
                .roles(Collections.singletonList(DISABLE_SECURITY_ROLES))
                .build();
    }
}
