package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.BaseEntity;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T save(T e);

    T update(T e);

    void delete(T e);

    Optional<T> findById(String id);

    List<T> findAll();
}
