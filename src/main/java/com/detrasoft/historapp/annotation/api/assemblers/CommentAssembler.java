package com.detrasoft.historapp.annotation.api.assemblers;

import com.detrasoft.framework.api.dto.converters.GenericRepresentationModelDTOAssembler;
import com.detrasoft.historapp.annotation.api.controllers.CommentController;
import com.detrasoft.historapp.annotation.domain.dtos.CommentDTO;
import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import com.detrasoft.historapp.annotation.domain.entities.Comment;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Log
@Component
public class CommentAssembler extends GenericRepresentationModelDTOAssembler<Comment, CommentDTO> {

    public CommentAssembler() {
        super(CommentController.class, CommentDTO.class);
    }

    @Override
    public Comment toEntity(CommentDTO dto) {
        var entity = new Comment();
        BeanUtils.copyProperties(dto, entity);
        entity.setAnnotation(Annotation.builder().id(dto.getIdDetail()).build());
        return entity;
    }
}
