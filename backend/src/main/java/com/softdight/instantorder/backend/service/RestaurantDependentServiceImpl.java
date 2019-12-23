package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.model.RestaurantDependent;
import com.softdight.instantorder.backend.repository.RestaurantDependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("restaurantDependentServiceImpl")
@Transactional
@Qualifier("restaurantDependentService")
public class RestaurantDependentServiceImpl<T extends RestaurantDependent> extends BaseServiceImpl<T> implements RestaurantDependentService<T>{


    protected RestaurantDependentRepository<T> restaurantDependentRepository;

    @Override
    public Optional<T> findByNameAndRestaurant(String name, Restaurant restaurant) {
        return restaurantDependentRepository.findByNameAndRestaurant(name,restaurant);
    }
}
