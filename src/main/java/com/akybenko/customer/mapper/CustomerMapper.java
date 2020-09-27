package com.akybenko.customer.mapper;

import org.mapstruct.Mapper;

import com.akybenko.customer.data.dto.CustomerDtoGenerated;
import com.akybenko.customer.data.entities.CustomerEntity;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CustomerMapper {

    CustomerDtoGenerated toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDtoGenerated dto);
}
