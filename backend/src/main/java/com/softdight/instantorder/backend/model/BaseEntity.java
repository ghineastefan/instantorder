package com.softdight.instantorder.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Data
public abstract class BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, columnDefinition = "VARCHAR(36) default UUID()")
    @Size(min = 1, max = 36, message = "ID should be between 1 and 36!")
    private String id;
}
