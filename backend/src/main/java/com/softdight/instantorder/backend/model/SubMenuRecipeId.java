package com.softdight.instantorder.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubMenuRecipeId implements Serializable {

    private String subMenu;

    private String recipe;
}
