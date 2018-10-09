/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.form.UserForm;
import com.example.forum.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@RequestMapping(ApiConstants.User.CONTROLLER_MAPPING)
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiConstants.User.REGISTRATION)
    public String registrationForm(UserForm userForm) {
        return "user/registration";
    }

    @PostMapping(ApiConstants.User.REGISTRATION)
    public String confirmRegistration(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/registration";
        }
        userService.create(userForm.getUsername().toLowerCase(), userForm.getLastName(), userForm.getFirstName(),
                userForm.getPassword());

        return "redirect:/login";
    }
}
