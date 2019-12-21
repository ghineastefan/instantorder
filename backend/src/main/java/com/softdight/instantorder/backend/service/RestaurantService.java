package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Restaurant;

import java.math.BigInteger;
import java.util.Optional;

public interface RestaurantService extends BaseService<Restaurant> {
    Optional<Restaurant> findByUserId(Long l);
}
