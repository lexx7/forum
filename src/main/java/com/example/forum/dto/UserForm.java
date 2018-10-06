/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 4, max = 20)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    @Size(min = 2, max = 255)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 255)
    private String firstName;
}
