package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "MENU", catalog = "MENU_SCHEMA")
public class Menu extends RestaurantDependent {

    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "MENU_TYPE_ID", referencedColumnName = "ID")
    private MenuType menuTypeId;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<MenuSubMenu> subMenus;

    public Set<SubCategory> getSubCategories(){
        Set<SubCategory> subCategories = new HashSet<>();

        for (MenuSubMenu menuSubMenu:
             subMenus) {
            Set<SubCategorySubMenu> cate = menuSubMenu.getSubmenu().getCategories();
            cate.forEach(x -> subCategories.add(x.getSubcategory()));
        }

        return subCategories;
    }
}
