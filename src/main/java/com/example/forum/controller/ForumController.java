/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiConstants.Forum.CONTROLLER_MAPPING)
public class ForumController {

    @GetMapping(ApiConstants.Forum.VIEW)
    public String view(Model model) {

        return ApiConstants.Forum.URI_VIEW;
    }
}
