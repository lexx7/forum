/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.security.details;

import com.example.forum.persistence.entity.Permission;
import com.example.forum.persistence.entity.Role;
import com.example.forum.security.util.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link User} implementation which contains user roles related permissions.
 */
public class PermissionUserDetails extends User {

    private Set<Permission> permissions = new HashSet<>();
    private long userId = SecurityUtils.NONEXISTENT_USER_ID;

    public PermissionUserDetails(String username,
                                 long id,
                                 String password,
                                 Collection<? extends GrantedAuthority> authorities,
                                 Set<Role> roles) {
        super(username, password, authorities);
        this.userId = id;
        updatePermissions(roles);
    }

    private void updatePermissions(Set<Role> roles) {
        for (Role nextRole : roles) {
            permissions.addAll(nextRole.getPermissions());
        }
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public long getUserId() {
        return userId;
    }
}
