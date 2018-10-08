/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

/**
 * Enum describing user role permission.
 */
public enum Permission {
    VIEW_FORUM(0),
    DELETE_ALL_MESSAGE(1),
    DELETE_ALL_SUBJECT(2);

    private long id;

    private Permission(long id) {
        this.id = id;
    }
}
