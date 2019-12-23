package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "SUBMENU", catalog = "MENU_SCHEMA")
public class SubMenu extends RestaurantDependent{

    @Column(name = "PATH_TO_PHOTO")
    private String pathToPhoto;

    /*
    * Each submenu have one or more categories
    * */
    @OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL)
    private Set<SubCategorySubMenu> categories;

    @OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL)
    private Set<SubMenuRecipe> recipes;

    public Recipe getRecipeById(String recipeId){
        for(SubMenuRecipe subMenuRecipe : getRecipes()){
            if(subMenuRecipe.getRecipe().getId().equals(recipeId)){
                return subMenuRecipe.getRecipe();
            }
        }
        return null;
    }

}
