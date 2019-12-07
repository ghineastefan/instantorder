package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.model.Recipe;
import com.softdight.instantorder.backend.service.IngredientService;
import com.softdight.instantorder.backend.service.RecipeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/menu/")
public class MenuController {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    @Qualifier("recipeService")
    RecipeService recipeService;

    @GetMapping("ingredient/find-all")
    public ResponseEntity<?> findAllIngredients() {

        return new ResponseEntity<>(ingredientService.findAll(), HttpStatus.OK);
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




}
