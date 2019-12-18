package com.softdight.instantorder.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "DESCRIPTABLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Descriptable extends BaseEntity{

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(150) default NULL")
    @Size(max = 150, message = "Description too long!")
    private String description;

}
