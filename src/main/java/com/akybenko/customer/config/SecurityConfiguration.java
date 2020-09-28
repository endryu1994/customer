package com.akybenko.customer.config;

import static com.akybenko.customer.constant.Security.DEFAULT_PROFILE;
import static com.akybenko.customer.constant.Security.USER_SERVICE_BEAN_NAME;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.akybenko.customer.service.UserService;
import com.akybenko.customer.service.impl.DisableSecurityUserServiceImpl;
import com.akybenko.customer.service.impl.EnableSecurityUserServiceImpl;

@Configuration
public class SecurityConfiguration {

    @Bean(USER_SERVICE_BEAN_NAME)
    @Profile(DEFAULT_PROFILE)
    public UserService defaultSecurityUserService() {
        return new EnableSecurityUserServiceImpl();
    }

    @Bean(USER_SERVICE_BEAN_NAME)
    @ConditionalOnMissingBean
    public UserService disableSecurityUserService() {
        return new DisableSecurityUserServiceImpl();
    }
}
