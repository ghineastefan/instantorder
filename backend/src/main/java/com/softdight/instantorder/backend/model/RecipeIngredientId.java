package com.softdight.instantorder.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecipeIngredientId implements Serializable {

    private String recipe;

    private String ingredient;
}
