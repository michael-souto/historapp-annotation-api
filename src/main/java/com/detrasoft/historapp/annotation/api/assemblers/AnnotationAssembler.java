package com.detrasoft.historapp.annotation.api.assemblers;

import com.detrasoft.framework.api.dto.converters.GenericRepresentationModelDTOAssembler;
import com.detrasoft.historapp.annotation.api.controllers.AnnotationController;
import com.detrasoft.historapp.annotation.domain.dtos.*;
import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import com.detrasoft.historapp.annotation.domain.entities.Comment;
import com.detrasoft.historapp.annotation.domain.services.client.character.CharacterClientService;
import com.detrasoft.historapp.annotation.domain.services.client.event.EventClientService;
import com.detrasoft.historapp.annotation.domain.services.client.locale.LocaleClientService;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Log
@Component
public class AnnotationAssembler extends GenericRepresentationModelDTOAssembler<Annotation, AnnotationDTO> {

    @Autowired
    private CharacterClientService characterClientService;
    @Autowired
    private LocaleClientService localeClientService;
    @Autowired
    private EventClientService eventClientService;

    public AnnotationAssembler() {
        super(AnnotationController.class, AnnotationDTO.class);
    }

    @Override
    protected void copyEntityToDto(Annotation obj, AnnotationDTO dto) {
        super.copyEntityToDto(obj, dto);

        // comments
        if (obj.getComments() != null && obj.getComments().size() > 0) {
            dto.setComments(new ArrayList<>());
            for (var comment : obj.getComments()) {
                var commentDTO = new CommentDTO();
                BeanUtils.copyProperties(comment, commentDTO);
                dto.getComments().add(commentDTO);
            }
        }

        // Characters from API
        if (obj.getCharactersIds() != null && obj.getCharactersIds().size() > 0) {
            var request = characterClientService.findByListId(obj.getCharactersIds());
            if (request != null && request.getBody() != null && request.getBody().size() > 0) {
                dto.setCharacters(request.getBody().stream().map(x -> CharacterDTO.builder().id(x.getId()).name(x.getName()).build()).toList());
            } else {
                dto.setCharacters(obj.getCharactersIds().stream().map(x -> CharacterDTO.builder().id(x).build()).toList());
            }
        }

        // Locales from API
        if (obj.getLocalesIds() != null && obj.getLocalesIds().size() > 0) {
            var request = localeClientService.findByListId(obj.getLocalesIds());
            if (request != null && request.getBody() != null && request.getBody().size() > 0) {
                dto.setLocales(request.getBody().stream().map(x -> LocaleDTO.builder().id(x.getId()).name(x.getName()).build()).toList());
            } else {
                dto.setLocales(obj.getLocalesIds().stream().map(x -> LocaleDTO.builder().id(x).build()).toList());
            }
        }

        // Events from API
        if (obj.getEventsIds() != null && obj.getEventsIds().size() > 0) {
            var request = eventClientService.findByListId(obj.getEventsIds());
            if (request != null && request.getBody() != null && request.getBody().size() > 0) {
                dto.setEvents(request.getBody().stream().map(x -> EventDTO.builder().id(x.getId()).title(x.getTitle()).build()).toList());
            } else {
                dto.setEvents(obj.getEventsIds().stream().map(x -> EventDTO.builder().id(x).build()).toList());
            }
        }
    }

    @Override
    protected void copyDtoToEntity(AnnotationDTO dto, Annotation annotation) {
        super.copyDtoToEntity(dto, annotation);

        if (dto.getComments() != null && dto.getComments().size() > 0) {
            annotation.setComments(dto.getComments().stream().map(
                    x -> Comment.builder()
                            .id(x.getId())
                            .text(x.getText())
                            .indexReference(x.getIndexReference())
                            .lengthReference(x.getLengthReference())
                            .textReference(x.getTextReference())
                            .build()
            ).toList());
        }

        if (dto.getCharacters() != null && dto.getCharacters().size() > 0) {
            annotation.setCharactersIds(dto.getCharacters().stream().map(CharacterDTO::getId).toList());
        }

        if (dto.getLocales() != null && dto.getLocales().size() > 0) {
            annotation.setLocalesIds(dto.getLocales().stream().map(LocaleDTO::getId).toList());
        }

        if (dto.getEvents() != null && dto.getEvents().size() > 0) {
            annotation.setEventsIds(dto.getEvents().stream().map(EventDTO::getId).toList());
        }
    }
}
