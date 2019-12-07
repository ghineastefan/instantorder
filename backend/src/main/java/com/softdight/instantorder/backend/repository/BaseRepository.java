package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.BaseEntity;
import com.softdight.instantorder.backend.model.Ingredient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface BaseRepository extends JpaRepository<BaseEntity, String> {
}
