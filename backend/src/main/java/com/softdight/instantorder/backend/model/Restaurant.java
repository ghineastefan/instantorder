package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantTable> restaurantTables;
}
