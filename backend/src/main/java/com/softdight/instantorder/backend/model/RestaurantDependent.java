package com.softdight.instantorder.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "RESTAURANT_DEPENDENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RestaurantDependent extends Descriptable{

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    private Restaurant restaurant;

    @NotNull(message = "ERROR: name cannot be null")
    @Column(name = "NAME")
    private String name;
}
