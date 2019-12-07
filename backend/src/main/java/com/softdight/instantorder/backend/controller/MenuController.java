package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.service.IngredientService;
import com.softdight.instantorder.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
