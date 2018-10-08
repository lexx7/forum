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
import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Instant dateTime;

    public Subject(String title, Instant dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }
}
