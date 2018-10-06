/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.dto.MessageForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiConstants.Message.CONTROLLER_MAPPING)
public class MessageController {

    @GetMapping(ApiConstants.Message.VIEW)
    public String view() {
        return "";
    }

    @GetMapping(ApiConstants.Message.CREATE)
    public String createForm(MessageForm messageForm) {
        return ApiConstants.Message.URI_CREATE;
    }

    @PostMapping(ApiConstants.Message.CREATE)
    public String create() {
        return "";
    }

    @PostMapping(ApiConstants.Message.DELETE)
    public String delete() {
        return "";
    }
}
