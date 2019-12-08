package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CATEGORY", catalog = "MENU_SCHEMA")
public class Category extends BaseEntity{
}
