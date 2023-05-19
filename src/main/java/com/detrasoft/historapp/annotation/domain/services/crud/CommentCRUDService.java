package com.detrasoft.historapp.annotation.domain.services.crud;

import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import com.detrasoft.historapp.annotation.domain.entities.Comment;
import com.detrasoft.historapp.annotation.domain.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentCRUDService extends GenericCRUDService<Comment> {
    public CommentCRUDService(CommentRepository repository) {
        super(repository);
    }
}
