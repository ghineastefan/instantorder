package com.softdight.instantorder.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Data
public abstract  class Descriptable extends BaseEntity{

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(36) default NULL")
    @Size(max = 150, message = "Description too long!")
    private String description;

}
