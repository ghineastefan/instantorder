package com.softdight.instantorder.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuSubMenuId implements Serializable {

    private String menu;

    private String submenu;
}
