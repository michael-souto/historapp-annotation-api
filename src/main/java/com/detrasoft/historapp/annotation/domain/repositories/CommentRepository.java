package com.detrasoft.historapp.annotation.domain.repositories;

import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import com.detrasoft.historapp.annotation.domain.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends GenericCRUDRepository<Comment> {
    Page<Comment> findByAnnotationId(Long idDetail, Pageable pageable);
}
