package com.detrasoft.historapp.annotation.api.controllers;

import com.detrasoft.framework.api.controllers.hateoas.GenericHateoasDetailController;
import com.detrasoft.framework.crud.entities.GenericEntity;
import com.detrasoft.historapp.annotation.api.assemblers.CommentAssembler;
import com.detrasoft.historapp.annotation.domain.dtos.CommentDTO;
import com.detrasoft.historapp.annotation.domain.repositories.CommentRepository;
import com.detrasoft.historapp.annotation.domain.services.crud.CommentCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "annotation/{idDetail}/comments")
public class CommentController extends GenericHateoasDetailController<CommentDTO> {

    @Autowired
    private CommentRepository _commentRepository;

    @Autowired
    public CommentController(CommentCRUDService service, CommentAssembler assembler) {
        super(service, assembler);
    }

    @Override
    protected void setIdSubDetailInDTO(Long idDetail, Long idSubDetail, CommentDTO dto) {
        dto.setIdDetail(idDetail);
    }

    @Override
    protected Page<? extends GenericEntity> findAllByIdDetail(Long idDetail, Pageable pageable) {
        return _commentRepository.findByAnnotationId(idDetail, pageable);
    }
}
