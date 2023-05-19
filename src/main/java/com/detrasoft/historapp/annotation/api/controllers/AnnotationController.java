package com.detrasoft.historapp.annotation.api.controllers;

import com.detrasoft.framework.api.controllers.hateoas.GenericHateoasCRUDController;
import com.detrasoft.historapp.annotation.api.assemblers.AnnotationAssembler;
import com.detrasoft.historapp.annotation.domain.dtos.AnnotationDTO;
import com.detrasoft.historapp.annotation.domain.services.crud.AnnotationCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/annotation")
public class AnnotationController extends GenericHateoasCRUDController<AnnotationDTO> {

    @Autowired
    public AnnotationController(AnnotationCRUDService service, AnnotationAssembler assembler) {
        super(service, assembler);
    }
}