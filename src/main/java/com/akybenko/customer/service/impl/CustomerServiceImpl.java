package com.akybenko.customer.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.data.entities.CustomerEntity;
import com.akybenko.customer.repo.CustomerRepository;
import com.akybenko.customer.service.AbstractService;
import com.akybenko.customer.service.CustomerService;
import com.akybenko.customer.service.mapper.CustomerMapperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl extends AbstractService<CustomerEntity> implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperService customerMapperService;

    @Override
    protected JpaRepository<CustomerEntity, UUID> repository() {
        return customerRepository;
    }

    @Override
    public CustomerDtoGenerated findById(UUID id) {
        log.debug("CustomerServiceImpl#findById(id = '{}')", id);
        CustomerEntity entity = findByUuid(id);
        return customerMapperService.toDto(entity);
    }

    @Override
    @Transactional
    public CustomerDtoGenerated create(CustomerDtoGenerated entity) {
        log.debug("CustomerServiceImpl#create(entity = '{}')", entity);
        CustomerEntity customer = customerMapperService.toEntity(entity);
        CustomerEntity savedCustomer = create(customer);
        return customerMapperService.toDto(savedCustomer);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        log.debug("CustomerServiceImpl#deleteById(id = '{}')", id);
        deleteByUuid(id);
    }
}
