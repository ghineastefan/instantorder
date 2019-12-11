package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "RESTAURANT_TYPE", catalog = "RESTAURANT_SCHEMA")
public class RestaurantType extends BaseEntity{
}