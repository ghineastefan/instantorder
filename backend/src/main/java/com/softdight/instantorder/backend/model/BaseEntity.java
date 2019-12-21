package com.softdight.instantorder.backend.model;

import jdk.jfr.Enabled;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "BASE_ENTITY")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, columnDefinition = "VARCHAR(36) default UUID()")
    @Size(min = 1, max = 36, message = "ID should be between 1 and 36!")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
}
