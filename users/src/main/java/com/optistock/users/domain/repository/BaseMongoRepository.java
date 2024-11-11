package com.optistock.users.domain.repository;

import com.optistock.users.commons.exceptions.AlreadyExistsException;
import com.optistock.users.commons.exceptions.NotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BaseMongoRepository<T, ID> extends MongoRepository<T, ID> {


    default T findByElementOrThrow(Optional<T> result, String fieldName, String fieldValue) {
        return result.orElseThrow(() -> new NotFoundException("No se encontró " + fieldName + " con valor: " + fieldValue));
    }

    default T saveIfNotExists(Optional<T> result, String fieldName, String fieldValue) {
        result.ifPresent(element -> new  AlreadyExistsException("ya existe " + fieldName + " con valor: " + fieldValue));
        return result.orElse(null);
    }
}