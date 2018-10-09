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

import java.time.Instant;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Override
    public Page<Message> viewAll(Long subjectId, Pageable pageable) {
        return messageRepository.findAllBySubjectIdOrderByDateTimeDesc(subjectId, pageable);
    }

    @Override
    public void create(String content, Long subjectId) {
        Subject subject = new Subject();
        subject.setId(subjectId);
        User user = new User();
        user.setId(SecurityUtils.getCurrentUserId());
        messageRepository.save(new Message(content,
                subject, user, Instant.now()));
    }

    @Override
    public void delete(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
