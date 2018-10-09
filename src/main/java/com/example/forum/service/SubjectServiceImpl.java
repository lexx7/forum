/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Subject;
import com.example.forum.persistence.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void create(String title) {
        Subject subject = new Subject(title, Instant.now());
        subjectRepository.save(subject);
    }

    @Override
    public Page<Subject> viewAll(Pageable pageable) {
        return subjectRepository.findAllByOrderByMessagesDateTimeDesc(pageable);
    }

    @Override
    public void delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public Subject getItem(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }
}
