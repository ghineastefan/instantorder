package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
}
