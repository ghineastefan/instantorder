package com.softdight.instantorder.backend.repository;


import com.softdight.instantorder.backend.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    List<Menu> findAllByRestaurantId(String restaurantId);
}
