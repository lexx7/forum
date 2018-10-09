/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    /**
     * All message with subject id
     *
     * @param subjectId
     * @param pageable
     * @return
     */
    public Page<Message> viewAll(Long subjectId, Pageable pageable);

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
