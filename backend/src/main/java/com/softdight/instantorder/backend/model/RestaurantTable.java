package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "RESTAURANT_TABLE", catalog = "RESTAURANT_SCHEMA")
public class RestaurantTable extends BaseEntity{

    @NotNull
    @Column(name = "IDENTIFIER_ID")
    private String identifierId;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    private Restaurant restaurant;
}
