/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.User;

import java.util.NoSuchElementException;

public interface UserService {
    /**
     * Create a new user
     *
     * @param username
     * @param lastName
     * @param firstName
     * @param password
     */
    public void create(String username, String lastName, String firstName, String password);

    public User findByUsername(String username) throws NoSuchElementException;
}
