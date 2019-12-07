package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Table(name = "DESCRIPTABLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Descriptable extends BaseEntity{

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(150) default NULL")
    @Size(max = 150, message = "Description too long!")
    private String description;

}
