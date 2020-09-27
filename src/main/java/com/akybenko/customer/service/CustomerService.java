package com.akybenko.customer.service;

import java.util.UUID;

import com.akybenko.customer.data.dto.CustomerDtoGenerated;

public interface CustomerService {

    CustomerDtoGenerated findById(UUID id);

    CustomerDtoGenerated create(CustomerDtoGenerated entity);

    void deleteById(UUID id);
}
