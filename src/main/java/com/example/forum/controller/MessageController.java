/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.form.MessageForm;
import com.example.forum.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(ApiConstants.Message.CONTROLLER_MAPPING)
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;

    @PostMapping(ApiConstants.Message.PATH_CREATE)
    public String create(@PathVariable Long subjectId, @Valid MessageForm messageForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            messageService.create(messageForm.getContent(), subjectId);
        }
        return "redirect:/" + ApiConstants.Subject.CONTROLLER_MAPPING + "/" + subjectId;
    }

    @PostMapping(ApiConstants.Message.DELETE)
    public String delete(@PathVariable Long messageId, @RequestParam("subjectId") Long subjectId) {
        messageService.delete(messageId);
        return "redirect:/" + ApiConstants.Subject.CONTROLLER_MAPPING + "/" + subjectId;
    }
}
