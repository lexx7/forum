/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private Long id;

    private String title;

    private Instant dateTime;
}
