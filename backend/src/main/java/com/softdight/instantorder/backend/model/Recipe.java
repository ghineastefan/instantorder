package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "RECIPE", schema = "MENU_SCHEMA")
public class Recipe extends Descriptable {

    @Column(name = "COOK_TIME", columnDefinition = "SMALLINT(3) DEFAULT NULL")
    private Integer cookTime;

    @JoinColumn(name = "INGREDIENT_ID")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Ingredient> ingredients = new ArrayList<>();
    // TODO change this with a many to many table
}
