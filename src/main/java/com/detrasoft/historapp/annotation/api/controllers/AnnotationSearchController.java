package com.detrasoft.historapp.annotation.api.controllers;

import com.detrasoft.historapp.annotation.api.assemblers.AnnotationAssembler;
import com.detrasoft.historapp.annotation.domain.dtos.AnnotationDTO;
import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import com.detrasoft.historapp.annotation.domain.repositories.AnnotationRepository;
import com.detrasoft.historapp.annotation.domain.specifications.AnnotationSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/annotation/search")
public class AnnotationSearchController {

    @Autowired

    private AnnotationRepository _annotationRepository;

    @Autowired
    private AnnotationAssembler _annotationAssembler;

    @GetMapping(value = "")
    public ResponseEntity<Page<AnnotationDTO>> search(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "tag", required = false) String tag,
            @RequestParam(name = "all", required = false) String all,
            @RequestParam(name = "events-ids", required = false) List<Long> eventsIds,
            @RequestParam(name = "characters-ids", required = false) List<Long> charactersIds,
            @RequestParam(name = "locales-ids", required = false) List<Long> localesIds,
            Pageable pageable) {

        Page<Annotation> list = (all != null && !all.isBlank())
                ? _annotationRepository.findAll(AnnotationSpecs.byAllFields(all), pageable)
                : _annotationRepository.findAll(AnnotationSpecs.byTitle(title)
                        .and(AnnotationSpecs.byText(description))
                        .and(AnnotationSpecs.byTag(tag))
                        .and(AnnotationSpecs.byEvents(eventsIds))
                        .and(AnnotationSpecs.byCharacters(charactersIds))
                        .and(AnnotationSpecs.byLocales(localesIds))
                , pageable);

        Page<AnnotationDTO> resultList = new PageImpl<AnnotationDTO>(
                list.getContent().stream()
                        .map(obj -> _annotationAssembler.toModel(obj)).toList(), pageable, list.getTotalElements());

        return ResponseEntity.ok().body(resultList);
    }
}
