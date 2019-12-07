package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "RECIPE_INGREDIENT", schema = "menu_schema", catalog = "menu_schema")
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {

    @Id
    @Column(name = "RECIPE_ID")
    @JsonIgnore
    private String recipe;

    @Id
    @ManyToOne
    private Ingredient ingredient;

    @Column(name = "QUANTITY")
    private Double quantity;

}
