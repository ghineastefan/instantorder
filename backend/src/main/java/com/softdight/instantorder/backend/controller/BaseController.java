package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.constants.ErrorConstants;
import com.softdight.instantorder.backend.constants.ResponseConstants;
import com.softdight.instantorder.backend.exception.types.InstantOrderException;
import com.softdight.instantorder.backend.model.BaseEntity;
import com.softdight.instantorder.backend.model.Restaurant;
import com.softdight.instantorder.backend.model.RestaurantDependent;
import com.softdight.instantorder.backend.model.User;
import com.softdight.instantorder.backend.service.BaseService;
import com.softdight.instantorder.backend.service.RestaurantDependentService;
import com.softdight.instantorder.backend.service.RestaurantService;
import com.softdight.instantorder.backend.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.Optional;

public abstract class BaseController {

    @Value("${app.jwt.secret}")
    protected String jwtSecret;

    @Autowired
    protected UserService userService;

    @Autowired
    @Qualifier("restaurantService")
    RestaurantService restaurantService;

    protected Restaurant getRestaurantFromToken(final String token) throws InstantOrderException {
        final User user = getUserFromToken(token);

        Optional<Restaurant> restaurantResource = restaurantService.findByUserId(user.getId());

        if(restaurantResource.isEmpty()){
            throw new InstantOrderException("No restaurant with that id");
        }

        return restaurantResource.get();
    }

    protected User getUserFromToken(String token){
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        final String username = claims.getSubject();

        User user = userService.findByUsername(username);

        if(user == null){
            throw new InstantOrderException("Wrong token");
        }

        return user;
    }

    protected  <T extends RestaurantDependent> ResponseEntity<?> createObjDependRestaurant(String token, T obj, BaseService<T> baseService) throws InstantOrderException {
        Restaurant restaurant = getRestaurantFromToken(token);

        obj.setRestaurant(restaurant);

        if(obj.getId() != null && baseService.findById(obj.getId()).isPresent()){
            return new ResponseEntity<>(ErrorConstants.THIS_OBJECT_ID_ALREADY_EXIST_IN_DB,HttpStatus.BAD_REQUEST);
        }

        baseService.save(obj);

        return new ResponseEntity<>(ResponseConstants.OBJECT_CREATED, HttpStatus.OK);
    }

    protected  <T extends BaseEntity> ResponseEntity<?> createObj(T obj, BaseService<T> baseService) throws InstantOrderException {
        if(baseService.findById(obj.getId()).isPresent()){
            throw new InstantOrderException(ErrorConstants.THIS_OBJECT_ID_ALREADY_EXIST_IN_DB);
        }

        baseService.save(obj);

        return new ResponseEntity<>(ResponseConstants.OBJECT_CREATED, HttpStatus.OK);
    }

    protected  <T extends BaseEntity> ResponseEntity<?> updateObj(T obj, BaseService<T> baseService) throws InstantOrderException {
        if(baseService.findById(obj.getId()).isEmpty()){
            throw new InstantOrderException(ErrorConstants.THIS_OBJECT_ID_IS_NOT_IN_DB);
        }

        baseService.update(obj);

        return new ResponseEntity<>(ResponseConstants.OBJECT_UPDATED, HttpStatus.OK);
    }

    protected <T extends BaseEntity> T safeGetObject(String objId,BaseService<T> baseService) throws InstantOrderException {
        Optional<T> objResource = baseService.findById(objId);

        if(objResource.isEmpty()){
            throw new InstantOrderException(ErrorConstants.THIS_OBJECT_ID_IS_NOT_IN_DB + " " + objId);
        }

        return objResource.get();
    }

    protected <T extends RestaurantDependent> T safeGetObjectRestaurantDependent(String name, Restaurant restaurant, RestaurantDependentService<T> restaurantDependentService){
        Optional<T> objResource = restaurantDependentService.findByNameAndRestaurant(name,restaurant);

        if(objResource.isEmpty()){
            throw new InstantOrderException(ErrorConstants.CANNOT_FIND_THE_OBJECT_WITH_THAT_NAME + " " + name + " " + restaurant.getId());
        }

        return objResource.get();
    }

}
