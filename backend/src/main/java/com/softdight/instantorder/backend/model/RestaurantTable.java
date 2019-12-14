package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "RESTAURANT_TABLE", catalog = "RESTAURANT_SCHEMA")
public class RestaurantTable extends BaseEntity{

    @NotNull
    @Column(name = "IDENTIFIER_ID")
    private String identifierId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    private Restaurant restaurant;
}
