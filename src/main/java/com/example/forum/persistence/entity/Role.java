/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * JPA entity describing user role.
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Role {

    @Id
    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9_]*$")
    @Size(min = 4, max = 20)
    private String name;

    @NotNull
    @ElementCollection(targetClass = Permission.class)
    @CollectionTable(name = "permissions", joinColumns = {@JoinColumn(name = "role_id")})
    @Column(name = "permission_id", updatable = false)
    private Set<Permission> permissions;

    public Role(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
