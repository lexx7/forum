/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.form.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqUsernameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqUsername {
    String message() default "Username is not unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
