/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne(targetEntity = Subject.class)
    private Subject subject;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private Instant dateTime;

    public Message(String content, Subject subject, User user, Instant dateTime) {
        this.content = content;
        this.subject = subject;
        this.user = user;
        this.dateTime = dateTime;
    }
}
