package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.model.BaseEntity;
import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.model.RestaurantType;
import com.softdight.instantorder.backend.model.SubMenu;
import com.softdight.instantorder.backend.service.BaseService;
import com.softdight.instantorder.backend.service.RestaurantService;
import com.softdight.instantorder.backend.service.RestaurantTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/restaurant/")
public class RestaurantController {

    @Autowired
    @Qualifier("restaurantService")
    private RestaurantService restaurantService;

    @Autowired
    @Qualifier("restaurantTypeService")
    private RestaurantTypeService restaurantTypeService;


    @GetMapping("/find-all")
    @ApiOperation(value = "returns all restaurants")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Restaurant.class)
    })
    public ResponseEntity<?> findAllRestaurants(){

        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-all-restaurant-types")
    @ApiOperation(value = "returns all restaurant types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RestaurantType.class)
    })
    public ResponseEntity<?> findAllRestaurantType(){
        return new ResponseEntity<>(restaurantTypeService.findAll(), HttpStatus.OK);
    }

}
