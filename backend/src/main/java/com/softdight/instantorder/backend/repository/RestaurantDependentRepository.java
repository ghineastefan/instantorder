package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.model.RestaurantDependent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantDependentRepository<T extends RestaurantDependent> extends JpaRepository<T, String> {

    Optional<T> findByNameAndRestaurant(String name, Restaurant restaurant);
}
