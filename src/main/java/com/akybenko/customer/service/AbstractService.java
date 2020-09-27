package com.akybenko.customer.service;

import static com.akybenko.customer.constant.ErrorMessage.ENTITY_NOT_FOUND_ERROR_MESSAGE;
import static com.akybenko.customer.constant.ErrorMessage.ENTITY_NOT_FOUND_FORMAT;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akybenko.customer.data.AbstractEntity;
import com.akybenko.customer.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractService<E extends AbstractEntity> implements CommonService<E> {

    protected abstract JpaRepository<E, UUID> repository();

    @Override
    public E findByUuid(UUID id) {
        log.debug("AbstractService#findByUuid(id = '{}')", id);
        return repository().findById(id).orElseThrow(() -> {
            log.error(ENTITY_NOT_FOUND_ERROR_MESSAGE, id);
            return new EntityNotFoundException(String.format(ENTITY_NOT_FOUND_FORMAT, id));
        });
    }

    @Override
    public E create(E entity) {
        log.debug("AbstractService#create(entity = '{}')", entity);
        return repository().save(entity);
    }

    @Override
    public void deleteByUuid(UUID id) {
        log.debug("AbstractService#deleteByUuid(id = '{}')", id);
        repository().deleteById(id);
    }
}
