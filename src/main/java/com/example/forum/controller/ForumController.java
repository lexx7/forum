/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping({"/", ApiConstants.Forum.CONTROLLER_MAPPING})
public class ForumController {

    private static final int PAGE_SIZE = 10;

    private SubjectService subjectService;

    @Autowired
    public ForumController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping({"/", ApiConstants.Forum.VIEW})
    public String view(Model model, @PageableDefault(size = PAGE_SIZE) Pageable pageable) {
        model.addAttribute("page", subjectService.viewAll(pageable));
        return ApiConstants.Forum.TEMPLATES_VIEW;
    }
}
