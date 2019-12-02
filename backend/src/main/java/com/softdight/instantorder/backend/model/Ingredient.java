package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Table(name = "INGREDIENT", schema = "MENU_SCHEMA")
public class Ingredient extends BaseEntity {

    @Enumerated(EnumType.STRING)
    QuantityType quantityType;
}
