/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.repository;

import com.example.forum.persistence.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findAllBySubjectId(Long subjectId);
}
