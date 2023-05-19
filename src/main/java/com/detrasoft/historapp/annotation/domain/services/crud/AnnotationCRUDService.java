package com.detrasoft.historapp.annotation.domain.services.crud;

import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import com.detrasoft.historapp.annotation.domain.repositories.AnnotationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AnnotationCRUDService extends GenericCRUDService<Annotation> {
    public AnnotationCRUDService(AnnotationRepository repository) {
        super(repository);
    }

    public Annotation editLocale(Long idAnnotation, Long idLocale, boolean removeLocale) {
        var annotationFound = this.findById(idAnnotation);
        if (removeLocale) {
            annotationFound.getLocalesIds().removeIf(x -> x.equals(idLocale));
        } else {
            if (!annotationFound.getLocalesIds().contains(idLocale)) {
                annotationFound.getLocalesIds().add(idLocale);
            }
        }
        annotationFound = repository.save(annotationFound);
        return annotationFound;
    }

    public Annotation editCharacter(Long idAnnotation, Long idCharacter, boolean removeCharacter) {
        var annotationFound = this.findById(idAnnotation);
        if (removeCharacter) {
            annotationFound.getCharactersIds().removeIf(x -> x.equals(idCharacter));
        } else {
            if (!annotationFound.getCharactersIds().contains(idCharacter)) {
                annotationFound.getCharactersIds().add(idCharacter);
            }
        }
        annotationFound = repository.save(annotationFound);
        return annotationFound;
    }

    public Annotation editEvent(Long idAnnotation, Long idEvent, boolean removeEvent) {
        var annotationFound = this.findById(idAnnotation);
        if (removeEvent) {
            annotationFound.getEventsIds().removeIf(x -> x.equals(idEvent));
        } else {
            if (!annotationFound.getEventsIds().contains(idEvent)) {
                annotationFound.getEventsIds().add(idEvent);
            }
        }
        annotationFound = repository.save(annotationFound);
        return annotationFound;
    }
    protected void beforeSave(Annotation entity) {

    }

    @Override
    protected void beforeInsert(Annotation entity) {
        beforeSave(entity);
        entity.getAudit().setCreatedAt(Instant.now());
        super.beforeInsert(entity);
    }

    @Override
    public void beforeUpdate(Annotation entity) {
        beforeSave(entity);
        entity.getAudit().setCreatedAt(Instant.now());
        super.beforeUpdate(entity);
    }
}
