package com.detrasoft.historapp.annotation.domain.dtos;

import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "locales")
public class LocaleDTO extends GenericRepresentationModelDTO<LocaleDTO> {
    private Long id;
    private String name;
}
