/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.repository;

import com.example.forum.persistence.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    public Page<Message> findAllBySubjectIdOrderByDateTimeDesc(Long subjectId, Pageable pageable);
}
