package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.BaseEntity;
import com.softdight.instantorder.backend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>{

    @Autowired
    private JpaRepository<T, String> baseRepo;


    @Override
    public T save(T e) {
        return baseRepo.save(e);
    }

    @Override
    public T update(T e) {
        return baseRepo.save(e);
    }

    @Override
    public void delete(T e) {
        baseRepo.deleteById(e.getId());
    }

    @Override
    public Optional<T> findById(String id) {
        return baseRepo.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepo.findAll();
    }
}
