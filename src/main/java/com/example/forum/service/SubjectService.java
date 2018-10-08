/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;

import com.example.forum.persistence.entity.Subject;

import java.util.List;

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
     */
    public List<Subject> viewAll();

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
}
