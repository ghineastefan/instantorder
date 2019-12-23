package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "RECIPE", catalog = "MENU_SCHEMA")
public class Recipe extends RestaurantDependent {

    @Column(name = "COOK_TIME", columnDefinition = "SMALLINT(3) DEFAULT NULL")
    private Integer cookTime;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeIngredient> ingredients;

    public Ingredient getIngredientById(String ingredientId){
        for(RecipeIngredient recipeIngredient : getIngredients()){
            if(recipeIngredient.getIngredient().getId().equals(ingredientId)){
                return recipeIngredient.getIngredient();
            }
        }
        return null;
    }
}