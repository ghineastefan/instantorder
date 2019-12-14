package com.softdight.instantorder.backend.service;

import com.softdight.instantorder.backend.model.RestaurantType;
import com.softdight.instantorder.backend.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("restaurantTypeServiceImpl")
@Transactional
@Qualifier("restaurantTypeService")
public class RestaurantTypeServiceImpl extends BaseServiceImpl<RestaurantType> implements RestaurantTypeService {

    private RestaurantTypeRepository restaurantTypeRepository;

    @Autowired
    public RestaurantTypeServiceImpl(RestaurantTypeRepository restaurantTypeRepository){
        this.baseRepo = restaurantTypeRepository;
        this.restaurantTypeRepository = restaurantTypeRepository;
    }
}
