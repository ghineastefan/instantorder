package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.model.RestaurantDependent;

import java.util.Optional;

public interface RestaurantDependentService<T extends RestaurantDependent> extends BaseService<T> {

    Optional<T> findByNameAndRestaurant(String name, Restaurant restaurant);
}
