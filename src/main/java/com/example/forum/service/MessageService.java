/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Message;

import java.util.List;

public interface MessageService {

    /**
     * All message with subject id
     *
     * @param subjectId
     * @return
     */
    public List<Message> viewAll(Long subjectId);

    /**
     * Create message with subjectId
     *
     * @param content
     * @param subjectId
     */
    public void create(String content, Long subjectId);

    /**
     * Delete message
     *
     * @param messageId
     */
    void delete(Long messageId);
}
