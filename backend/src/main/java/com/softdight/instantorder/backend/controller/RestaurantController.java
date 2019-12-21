package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.constants.ErrorConstants;
import com.softdight.instantorder.backend.exception.types.InstantOrderException;
import com.softdight.instantorder.backend.model.*;
import com.softdight.instantorder.backend.service.BaseService;
import com.softdight.instantorder.backend.service.RestaurantService;
import com.softdight.instantorder.backend.service.RestaurantTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends BaseController{

    @Autowired
    @Qualifier("restaurantTypeService")
    private RestaurantTypeService restaurantTypeService;

    @GetMapping("/public/find-all")
    @ApiOperation(value = "returns all restaurants")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Restaurant.class)
    })
    public ResponseEntity<?> findAllRestaurants(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/public/find-all-restaurant-types")
    @ApiOperation(value = "returns all restaurant types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RestaurantType.class)
    })
    public ResponseEntity<?> findAllRestaurantType(){
        return new ResponseEntity<>(restaurantTypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/admin/create")
    @ApiOperation(value = "creates a restaurant")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Restaurant.class)
    })
    public ResponseEntity<?> createRestaurant(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token, @RequestBody Restaurant restaurant){
        final User user = getUserFromToken(token);

        restaurant.setUserId(user.getId());

        return new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.OK);
    }

    @PutMapping("/admin/update")
    @ApiOperation(value = "update a restaurant")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<?> updateRestaurant(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token, @RequestBody Restaurant restaurant){
        final User user = getUserFromToken(token);

        if(!user.getId().equals(restaurant.getUserId())){
            throw new InstantOrderException(ErrorConstants.NOT_ENOUGH_RIGHTS_FOR_THIS_OBJECT);
        }

        return new ResponseEntity<>(restaurantService.update(restaurant), HttpStatus.OK);
    }



}
