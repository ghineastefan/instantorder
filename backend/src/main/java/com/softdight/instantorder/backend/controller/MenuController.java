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

    @PostMapping("submenu/admin/link-to-menu")
    @ApiOperation(value = "links a submenu to a menu")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",response = Menu.class)
    })
    public ResponseEntity<?> linkSubMenuToMenu(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token,
                                               @ApiParam(example = "menu_test") @RequestParam String menuName,
                                               @ApiParam(example = "men1") @RequestParam String subMenuName,
                                               @ApiParam(example = "10") @RequestParam Double price,
                                               @ApiParam(example = "12") @RequestParam Double sold) throws InstantOrderException {
        Restaurant restaurant = this.getRestaurantFromToken(token);
        Menu menu = this.safeGetObjectRestaurantDependent(menuName,restaurant,menuService);
        SubMenu subMenu = this.safeGetObjectRestaurantDependent(subMenuName,restaurant,subMenuService);

        if(menu.getSubmenuById(subMenu.getId()) != null){
            throw new InstantOrderException(ErrorConstants.OBJECT_ALREADY_EXIST_IN_LIST + " " + subMenuName);
        }

        MenuSubMenu menuSubMenu = new MenuSubMenu(menu.getId(),subMenu,price,sold);

        menu.getSubMenus().add(menuSubMenu);

        menuService.update(menu);

        return new ResponseEntity<>(menuService.findById(menu.getId()), HttpStatus.OK);
    }

    @PostMapping("recipe/admin/link-to-submenu")
    @ApiOperation(value = "links a recipe to a submenu. Just the recipe name will be taken into consideration")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",response = SubMenu.class)
    })
    public ResponseEntity<?> linkRecipeToSubmenu(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token,
                                                @ApiParam(example = "men1") @RequestParam String submenuName,
                                                 @RequestBody SubMenuRecipe subMenuRecipe) throws InstantOrderException {
        Restaurant restaurant = this.getRestaurantFromToken(token);
        SubMenu subMenu = this.safeGetObjectRestaurantDependent(submenuName,restaurant,subMenuService);
        Recipe recipe = this.safeGetObjectRestaurantDependent(subMenuRecipe.getRecipe().getName(),restaurant,recipeService);

        if(subMenu.getRecipeById(recipe.getId()) != null){
            throw new InstantOrderException(ErrorConstants.OBJECT_ALREADY_EXIST_IN_LIST + " " + recipe.getName());
        }

        SubMenuRecipe subMenuRecipeObj = new SubMenuRecipe(subMenu.getId(),recipe,subMenuRecipe.getCategory(),subMenuRecipe.getIsRequired(),subMenuRecipe.getPrice());

        subMenu.getRecipes().add(subMenuRecipeObj);
        subMenuService.update(subMenu);

        return new ResponseEntity<>(subMenuService.findById(subMenu.getId()), HttpStatus.OK);
    }

    @PostMapping("ingredient/admin/link-to-recipe")
    @ApiOperation(value = "links a recipe to a submenu. Just the recipe name will be taken into consideration")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",response = SubMenu.class)
    })
    public ResponseEntity<?> linkIngredientToRecipe(@ApiParam(example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnZW9yZ2VvNDU2N0BnbWFpbC5jb20iLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE1Nzc3ODQzOTV9.9t5dwYTLtEDIxGtoNNFNm18dYvRSZ8pK7K_p493nf_HLKS2Xyhrc2llLuDf7WK2ayO6Qw-2woNz9rRxAWLnojQ") @RequestParam String token,
                                                 @ApiParam(example = "RecipeTest1") @RequestParam String recipeName,
                                                 @RequestBody RecipeIngredient recipeIngredient) throws InstantOrderException {
        Restaurant restaurant = this.getRestaurantFromToken(token);
        Ingredient ingredient = this.safeGetObject(recipeIngredient.getIngredient().getId(),ingredientService);
        Recipe recipe = this.safeGetObjectRestaurantDependent(recipeName,restaurant,recipeService);

        if(recipe.getIngredientById(ingredient.getId()) != null){
            throw new InstantOrderException(ErrorConstants.OBJECT_ALREADY_EXIST_IN_LIST + " " + ingredient.getId());
        }

        RecipeIngredient recipeIngredientObj = new RecipeIngredient(recipe.getId(),ingredient,recipeIngredient.getQuantity());

        recipe.getIngredients().add(recipeIngredientObj);
        recipeService.update(recipe);

        return new ResponseEntity<>(recipeService.findById(recipe.getId()), HttpStatus.OK);
    }

}
