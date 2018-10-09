/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Instant dateTimeLastMessage;

    @OneToMany(mappedBy = "subject")
    private List<Message> messages;

    public Subject(String title, Instant dateTimeLastMessage) {
        this.title = title;
        this.dateTimeLastMessage = dateTimeLastMessage;
    }
}
