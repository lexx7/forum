/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.persistence.repository;

import com.example.forum.persistence.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {
    Page<Subject> findByOrderByDateTimeLastMessageDesc(Pageable pageable);
}
