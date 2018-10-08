/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping({ApiConstants.Forum.CONTROLLER_MAPPING, "/"})
public class ForumController {

    private SubjectService subjectService;

    @Autowired
    public ForumController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping({ApiConstants.Forum.VIEW, "/"})
    public String view(Model model) {
        model.addAttribute("subjects", subjectService.viewAll());
        return ApiConstants.Forum.TEMPLATES_VIEW;
    }
}
