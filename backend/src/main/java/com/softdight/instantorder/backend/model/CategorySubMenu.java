package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY_SUBMENU", schema = "menu_schema", catalog = "menu_schema")
@IdClass(CategorySubMenuId.class)
public class CategorySubMenu {

    @Id
    @Column(name = "SUBMENU_ID")
    @JsonIgnore
    private String subMenu;

    @Id
    @ManyToOne
    private Category category;
}
