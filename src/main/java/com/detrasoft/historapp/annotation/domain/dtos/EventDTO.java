package com.detrasoft.historapp.annotation.domain.dtos;

import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "events")
public class EventDTO extends GenericRepresentationModelDTO<EventDTO> {
    private Long id;
    private String title;
}
