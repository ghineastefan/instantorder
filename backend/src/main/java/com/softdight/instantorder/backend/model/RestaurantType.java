package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "RESTAURANT_TYPE", catalog = "RESTAURANT_SCHEMA")
public class RestaurantType extends BaseEntity{
}
