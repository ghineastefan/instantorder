package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Menu;

import java.util.List;

public interface MenuService extends BaseService<Menu>{

    List<Menu> findAllByRestaurantId(String restaurantId);

}
