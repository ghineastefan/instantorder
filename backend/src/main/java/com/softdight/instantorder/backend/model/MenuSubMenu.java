package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MENU_SUBMENU", catalog = "MENU_SCHEMA")
@IdClass(MenuSubMenuId.class)
public class MenuSubMenu {

    @Id
    @Column(name = "MENU_ID")
    @JsonIgnore
    private String menu;

    @Id
    @ManyToOne
    private SubMenu submenu;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "ON_SALE")
    private Double onSale;

}
