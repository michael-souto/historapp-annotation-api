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
public class EventAnnotationController {

    @Autowired
    AnnotationCRUDService service;
    @Autowired
    AnnotationAssembler assembler;

    @JsonView(ResponseView.put.class)
    @PostMapping(value = "/{id}/events/{idEvent}")
    public ResponseEntity<AnnotationDTO> add(@PathVariable Long id, @PathVariable Long idEvent) {
        return ResponseEntity.ok().body(assembler.toModel(service.editEvent(id, idEvent, false), true));
    }

    @DeleteMapping(value = "/{id}/events/{idEvent}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idEvent) {
        service.editEvent(id, idEvent, true);
        return ResponseEntity.noContent().build();
    }
}
