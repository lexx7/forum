/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {

    /**
     * Create a new subject with title
     *
     * @param title the title
     */
    public void create(String title);

    /**
     * View all subjects
     *
     * @return
     * @param pageable
     */
    public Page<Subject> viewAll(Pageable pageable);

    /**
     * Subject delete with subjectId
     *
     * @param subjectId the subject id
     */
    void delete(Long subjectId);

    /**
     * Get subject
     *
     * @param subjectId
     * @return
     */
    Subject getItem(Long subjectId);

    void save(Subject subject);
}
