package com.softdight.instantorder.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategorySubMenuId implements Serializable {

    private String subMenu;

    private String category;
}
