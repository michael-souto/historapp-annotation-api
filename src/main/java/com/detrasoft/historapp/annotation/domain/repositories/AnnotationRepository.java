package com.detrasoft.historapp.annotation.domain.repositories;

import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends GenericCRUDRepository<Annotation> {
}
