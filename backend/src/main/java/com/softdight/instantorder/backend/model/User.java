package com.softdight.instantorder.backend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user", schema = "auth")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null!")
    @Size(min = 2, max = 50, message = "Invalid first name length!")
    private String name;

    @Column(name = "username")
    @NotNull(message = "Username cannot be null!")
    @Size(min = 2, max = 30, message = "Invalid username length!")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Password cannot be null!")
    @Size(min = 6, message = "Invalid password length!")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @ApiModelProperty(required = false, hidden = true)
    private Role role;

    @Transient
    @ApiModelProperty(required = false, hidden = true)
    private String token;

    public GrantedAuthority getRole() {
        return role;
    }
}
