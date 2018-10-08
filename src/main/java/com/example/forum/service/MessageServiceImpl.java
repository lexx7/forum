/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Message;
import com.example.forum.persistence.entity.Subject;
import com.example.forum.persistence.entity.User;
import com.example.forum.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> viewAll(Long subjectId) {
        return messageRepository.findAllBySubjectId(subjectId);
    }

    @Override
    public void create(String content, Long subjectId) {
        Subject subject = new Subject();
        subject.setId(subjectId);
        User user = new User();
        user.setId(Long.valueOf(2));
        messageRepository.save(new Message(content,
                subject, user, Instant.now()));
    }

    @Override
    public void delete(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
