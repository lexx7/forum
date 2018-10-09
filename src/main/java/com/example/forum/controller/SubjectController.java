/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.controller;

import com.example.forum.constants.ApiConstants;
import com.example.forum.form.MessageForm;
import com.example.forum.form.SubjectForm;
import com.example.forum.service.MessageService;
import com.example.forum.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(ApiConstants.Subject.CONTROLLER_MAPPING)
public class SubjectController {

    private SubjectService subjectService;
    private MessageService messageService;

    @Autowired
    public SubjectController(SubjectService subjectService, MessageService messageService) {
        this.subjectService = subjectService;
        this.messageService = messageService;
    }

    @GetMapping(ApiConstants.Subject.PATH_VIEW)
    public String view(@PathVariable Long subjectId, Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("subject", subjectService.getItem(subjectId));
        model.addAttribute("page", messageService.viewAll(subjectId, pageable));
        model.addAttribute("messageForm", new MessageForm());
        return ApiConstants.Subject.TEMPLATES_VIEW;
    }

    @GetMapping(ApiConstants.Subject.CREATE)
    public String createForm(SubjectForm subjectForm) {
        return ApiConstants.Subject.TEMPLATES_CREATE;
    }

    @PostMapping(ApiConstants.Subject.CREATE)
    public String create(@Valid SubjectForm subjectForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiConstants.Subject.TEMPLATES_CREATE;
        }
        subjectService.create(subjectForm.getTitle());
        return "redirect:/";
    }

    @PostMapping(ApiConstants.Subject.DELETE)
    public String delete(@PathVariable Long subjectId) {
        subjectService.delete(subjectId);
        return "redirect:" + ApiConstants.Forum.TEMPLATES_VIEW;
    }
}
