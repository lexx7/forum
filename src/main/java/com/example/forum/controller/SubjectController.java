/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.dto.SubjectForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(ApiConstants.Subject.CONTROLLER_MAPPING)
public class SubjectController {

    @GetMapping(ApiConstants.Subject.VIEW)
    public String view() {
        return "";
    }

    @GetMapping(ApiConstants.Subject.CREATE)
    public String createForm(SubjectForm subjectForm) {
        return ApiConstants.Subject.URI_CREATE;
    }

    @PostMapping(ApiConstants.Subject.CREATE)
    public String create(@Valid SubjectForm subjectForm) {
        return "";
    }

    @PostMapping(ApiConstants.Subject.DELETE)
    public String delete() {
        return "";
    }
}
