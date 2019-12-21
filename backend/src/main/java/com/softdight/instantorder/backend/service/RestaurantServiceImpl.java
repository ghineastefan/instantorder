package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("restaurantServiceImpl")
@Transactional
@Qualifier("restaurantService")
public class RestaurantServiceImpl extends BaseServiceImpl<Restaurant> implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
        this.baseRepo = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> findByUserId(Long l) {
        return restaurantRepository.findByUserId(l);
    }
}
