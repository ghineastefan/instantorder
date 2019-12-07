package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "INGREDIENT", schema = "menu_schema")
public class Ingredient extends BaseEntity {

    @JoinColumn(name = "QUANTITY_TYPE_ID", referencedColumnName = "ID")
    @Enumerated(EnumType.STRING)
    QuantityType quantityTypeId;
}
