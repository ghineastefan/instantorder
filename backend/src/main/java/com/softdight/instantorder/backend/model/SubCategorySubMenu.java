package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SUBCATEGORY_SUBMENU", schema = "menu_schema", catalog = "menu_schema")
@IdClass(SubCategorySubMenuId.class)
public class SubCategorySubMenu {

    @Id
    @Column(name = "SUBMENU_ID")
    @JsonIgnore
    private String subMenu;

    @Id
    @ManyToOne
    private SubCategory subcategory;
}
