/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.repository;

import com.example.forum.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByName(String lcLogin);
}
