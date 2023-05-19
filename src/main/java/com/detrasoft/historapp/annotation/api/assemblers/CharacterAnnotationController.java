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
public class CharacterAnnotationController {

    @Autowired
    AnnotationCRUDService service;
    @Autowired
    AnnotationAssembler assembler;

    @JsonView(ResponseView.put.class)
    @PostMapping(value = "/{id}/characters/{idCharacter}")
    public ResponseEntity<AnnotationDTO> add(@PathVariable Long id, @PathVariable Long idCharacter) {
        return ResponseEntity.ok().body(assembler.toModel(service.editCharacter(id, idCharacter, false), true));
    }

    @DeleteMapping(value = "/{id}/characters/{idCharacter}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idCharacter) {
        service.editCharacter(id, idCharacter, true);
        return ResponseEntity.noContent().build();
    }
}
