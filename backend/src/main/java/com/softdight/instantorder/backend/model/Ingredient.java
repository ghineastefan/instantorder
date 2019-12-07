package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "INGREDIENT", schema = "MENU_SCHEMA")
public class Ingredient extends BaseEntity {

    @Enumerated(EnumType.STRING)
    QuantityType quantityType;
}
