package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "RESTAURANT", catalog = "restaurant_schema")
public class Restaurant extends Descriptable {

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RESTAURANT_TYPE_ID", referencedColumnName = "ID")
    private RestaurantType restaurantTypeId;

    @NotNull
    private BigInteger userId;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true)
    @JsonManagedReference
    private List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Menu> menus;
}
