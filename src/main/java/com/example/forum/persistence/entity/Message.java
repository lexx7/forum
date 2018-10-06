/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;

    private String content;

    @ManyToOne(targetEntity = Subject.class)
    private Subject subject;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private Instant dateTime;
}
