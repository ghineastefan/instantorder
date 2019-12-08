package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "SUBMENU", catalog = "MENU_SCHEMA")
public class SubMenu extends Descriptable{

    @Column(name = "PATH_TO_PHOTO")
    private String pathToPhoto;

    /*
    * Each submenu have one or more categories
    * */
    @OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL)
    private Set<SubCategorySubMenu> categories;

    @OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL)
    private Set<SubMenuRecipe> recipes;
}
