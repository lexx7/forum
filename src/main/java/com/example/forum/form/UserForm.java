/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.form;

import com.example.forum.form.validator.FieldMatch;
import com.example.forum.form.validator.UniqUsername;
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
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserForm {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$",
       message = "must contain letters or numbers")
    @Size(min = 2, max = 20)
    @UniqUsername
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%]*$",
       message = "must contain at least one number, a lowercase letter, an uppercase letter and a symbol (!@#$%)")
    @Size(min=8, max=255)
    private String password;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%]*$",
            message = "must contain at least one number, a lowercase letter, an uppercase letter and a symbol (!@#$%)")
    @Size(min=8, max=255)
    private String confirmPassword;

    @NotNull
    @Size(min = 2, max = 255)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 255)
    private String firstName;
}
