/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.dto.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(ApiConstants.User.CONTROLLER_MAPPING)
@Controller
public class UserController {

    @GetMapping(ApiConstants.User.REGISTRATION)
    public String registrationForm(UserForm userForm) {
        return "user/registration";
    }

    @PostMapping(ApiConstants.User.REGISTRATION)
    public String confirmRegistration(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/registration";
        }
        return "redirect:/login";
    }
}
