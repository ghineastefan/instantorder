package com.softdight.instantorder.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SUBMENU_RECIPE", catalog = "menu_schema")
@IdClass(SubMenuRecipeId.class)
public class SubMenuRecipe {

    @Id
    @Column(name = "SUBMENU_ID")
    @JsonIgnore
    private String subMenu;

    @Id
    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Category category;

    @Column(name = "IS_REQUIRED")
    private Boolean isRequired;

    @Column(name = "PRICE")
    private Double price;
}
