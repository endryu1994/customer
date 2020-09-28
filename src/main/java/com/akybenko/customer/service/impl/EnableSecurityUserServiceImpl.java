package com.akybenko.customer.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.akybenko.customer.data.UserInfo;
import com.akybenko.customer.service.UserService;

public class EnableSecurityUserServiceImpl implements UserService {

    @Override
    public UserInfo getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
        AccessToken token = principal.getKeycloakSecurityContext().getToken();
        return UserInfo.builder()
                .id(UUID.fromString(token.getSubject()))
                .username(token.getPreferredUsername())
                .firstName(token.getGivenName())
                .lastName(token.getFamilyName())
                .email(token.getEmail())
                .roles(new ArrayList<>(token.getRealmAccess().getRoles()))
                .build();
    }
}
