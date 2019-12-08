package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "RECIPE", schema = "MENU_SCHEMA")
public class Recipe extends Descriptable {

    @Column(name = "COOK_TIME", columnDefinition = "SMALLINT(3) DEFAULT NULL")
    private Integer cookTime;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeIngredient> ingredients;
}
