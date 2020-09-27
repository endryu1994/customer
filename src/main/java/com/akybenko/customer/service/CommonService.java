package com.akybenko.customer.service;

import java.util.UUID;

import com.akybenko.customer.data.AbstractEntity;

public interface CommonService<E extends AbstractEntity> {

    E findByUuid(UUID id);

    E create(E entity);

    void deleteByUuid(UUID id);
}
