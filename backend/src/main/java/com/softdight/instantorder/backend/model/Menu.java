package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "MENU", catalog = "MENU_SCHEMA")
public class Menu extends Descriptable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_TYPE_ID", referencedColumnName = "ID")
    private MenuType menuTypeId;

    @NotNull
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<MenuSubMenu> subMenus;
}
