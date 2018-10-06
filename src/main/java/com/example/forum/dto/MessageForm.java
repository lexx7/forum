/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageForm {
    @NotNull
    private String content;
}
