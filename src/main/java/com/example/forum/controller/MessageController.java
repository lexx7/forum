/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.dto.MessageForm;
import com.example.forum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(ApiConstants.Message.CONTROLLER_MAPPING)
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(ApiConstants.Message.PATH_CREATE)
    public String create(@PathVariable Long subjectId, MessageForm messageForm) {
        messageService.create(messageForm.getContent(), subjectId);
        return "redirect:/" + ApiConstants.Subject.CONTROLLER_MAPPING + "/" + subjectId;
    }

    @PostMapping(ApiConstants.Message.DELETE)
    public String delete(@PathVariable Long messageId, @RequestParam("subjectId") Long subjectId) {
        messageService.delete(messageId);
        return "redirect:/" + ApiConstants.Subject.CONTROLLER_MAPPING + "/" + subjectId;
    }
}
