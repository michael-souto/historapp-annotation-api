package com.detrasoft.historapp.annotation.api.assemblers;

import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.historapp.annotation.domain.dtos.AnnotationDTO;
import com.detrasoft.historapp.annotation.domain.services.crud.AnnotationCRUDService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/annotation")
public class LocaleAnnotationController {
    @Autowired
    AnnotationCRUDService service;
    @Autowired
    AnnotationAssembler assembler;

    @JsonView(ResponseView.put.class)
    @PostMapping(value = "/{id}/locales/{idLocale}")
    public ResponseEntity<AnnotationDTO> add(@PathVariable Long id, @PathVariable Long idLocale) {
        return ResponseEntity.ok().body(assembler.toModel(service.editLocale(id, idLocale, false), true));
    }

    @DeleteMapping(value = "/{id}/locales/{idLocale}")
    public ResponseEntity<Void> remove(@PathVariable Long id, @PathVariable Long idLocale) {
        service.editLocale(id, idLocale, true);
        return ResponseEntity.noContent().build();
    }
}
