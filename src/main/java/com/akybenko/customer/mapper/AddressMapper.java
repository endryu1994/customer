package com.akybenko.customer.mapper;

import org.mapstruct.Mapper;

import com.akybenko.customer.data.dto.AddressDtoGenerated;
import com.akybenko.customer.data.entities.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDtoGenerated toDto(AddressEntity entity);

    AddressEntity toEntity(AddressDtoGenerated dto);
}
