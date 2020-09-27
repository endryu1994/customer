package com.akybenko.customer.service.mapper;

import com.akybenko.customer.data.AbstractEntity;

public interface AbstractMapperService<T, S extends AbstractEntity> {

    T toDto(S entity);

    S toEntity(T dto);
}
