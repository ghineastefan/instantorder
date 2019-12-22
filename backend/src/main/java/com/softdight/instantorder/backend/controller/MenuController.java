package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.constants.ErrorConstants;
import com.softdight.instantorder.backend.constants.ResponseConstants;
import com.softdight.instantorder.backend.exception.types.InstantOrderException;
import com.softdight.instantorder.backend.jwt.JwtTokenProvider;
import com.softdight.instantorder.backend.model.*;
import com.softdight.instantorder.backend.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/public/menu/")
public class MenuController extends BaseController{

    @Autowired
    IngredientService ingredientService;

    @Autowired
    @Qualifier("recipeService")
    RecipeService recipeService;

    @Autowired
    @Qualifier("subMenuService")
    SubMenuService subMenuService;

    @Autowired
    @Qualifier("menuService")
    MenuService menuService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("ingredient/find-all")
    public ResponseEntity<?> findAllIngredients() {

        return new ResponseEntity<>(ingredientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("ingredient/admin/create")
    @ApiOperation(value = "creates an ingredient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient) throws InstantOrderException {
        return createObj(ingredient,ingredientService);
    }

    @PostMapping("ingredient/admin/update")
    @ApiOperation(value = "update ingredient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient) throws InstantOrderException {
        return updateObj(ingredient,ingredientService);
    }


    @GetMapping("recipe/find-all")
    public ResponseEntity<?> findAllRecipes(){
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }


    @GetMapping("recipe/get-by-id")
    @ApiOperation(value = "returns a recipe with that id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Recipe.class)
    })
    public ResponseEntity<?> getRecipeById(@ApiParam(example = "PIZZA CLASSIC") @RequestParam String recipeId){
        return new ResponseEntity<>(recipeService.findById(recipeId), HttpStatus.OK);
    }

    @PostMapping("recipe/admin/create")
    @ApiOperation(value = "creates a recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Recipe.class)
    })
    public ResponseEntity<?> createRecipe(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token, @RequestBody Recipe recipe) throws Exception {
        return this.createObjDependRestaurant(token,recipe,recipeService);
    }

    @GetMapping("submenu/find-all")
    @ApiOperation(value = "returns all subMenus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SubMenu.class)
    })
    public ResponseEntity<?> findAllSubMenus(){
        return new ResponseEntity<>(subMenuService.findAll(), HttpStatus.OK);
    }

    @GetMapping("find-all")
    @ApiOperation(value = "returns all Menus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Menu.class)
    })
    public ResponseEntity<?> findAllMenus(){
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }

    @GetMapping("find-all-by-restaurant")
    @ApiOperation(value = "returns all Menus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Menu.class)
    })
    public ResponseEntity<?> findAllMenusByRestaurant(@ApiParam(example = "Osteria Sempre Buono") @RequestParam String restaurantId){
        return new ResponseEntity<>(menuService.findAllByRestaurantId(restaurantId), HttpStatus.OK);
    }

    @PostMapping("/admin/create")
    @ApiOperation(value = "creates a menu")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<?> createMenu(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token,
                                        @RequestBody Menu menu) throws InstantOrderException {
        return createObjDependRestaurant(token,menu,menuService);
    }

    /*
    * A submenu can be create only with a menu attachment because we need to know the
    * restaurant
    * */
    @PostMapping("submenu/admin/create")
    @ApiOperation(value = "creates a submenu")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<?> createSubMenu(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token,
                                              @RequestBody SubMenu subMenu) throws InstantOrderException {
        return createObjDependRestaurant(token,subMenu,subMenuService);
    }

    private Restaurant safeGetRestaurant(String restaurantId) throws Exception {
        Optional<Restaurant> restaurantResource = restaurantService.findById(restaurantId);

        if(restaurantResource.isEmpty()){
            throw new Exception("No restaurant with that id");
        }

        return restaurantResource.get();
    }
}
