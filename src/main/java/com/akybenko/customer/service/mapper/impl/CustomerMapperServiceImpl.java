package com.akybenko.customer.service.mapper.impl;

import org.springframework.stereotype.Service;

import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.data.entities.CustomerEntity;
import com.akybenko.customer.mapper.CustomerMapper;
import com.akybenko.customer.service.mapper.CustomerMapperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerMapperServiceImpl implements CustomerMapperService {

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDtoGenerated toDto(CustomerEntity entity) {
        log.debug("CustomerMapperServiceImpl#toDto(entity = '{}')", entity);
        return customerMapper.toDto(entity);
    }

    @Override
    public CustomerEntity toEntity(CustomerDtoGenerated dto) {
        log.debug("CustomerMapperServiceImpl#toEntity(dto = '{}')", dto);
        return customerMapper.toEntity(dto);
    }
}
