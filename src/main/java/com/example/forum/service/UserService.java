/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

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
}
