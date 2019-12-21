package com.softdight.instantorder.backend.repository;

import com.softdight.instantorder.backend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,String> {

    Optional<Restaurant> findByUserId(Long l);
}
