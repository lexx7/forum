/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Message;
import com.example.forum.persistence.entity.Subject;
import com.example.forum.persistence.entity.User;
import com.example.forum.persistence.repository.MessageRepository;
import com.example.forum.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private SubjectService subjectService;

    @Override
    public Page<Message> viewAll(Long subjectId, Pageable pageable) {
        return messageRepository.findAllBySubjectIdOrderByDateTimeDesc(subjectId, pageable);
    }

    @Override
    @Transactional
    public void create(String content, Long subjectId) {
        Subject subject = subjectService.getItem(subjectId);
        User user = new User();
        user.setId(SecurityUtils.getCurrentUserId());
        Message message = new Message(content, subject, user, Instant.now());
        messageRepository.save(message);
        subject.setDateTimeLastMessage(message.getDateTime());
        subjectService.save(subject);
    }

    @Override
    public void delete(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
