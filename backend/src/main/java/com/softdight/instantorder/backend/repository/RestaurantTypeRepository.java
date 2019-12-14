package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType,String> {
}
