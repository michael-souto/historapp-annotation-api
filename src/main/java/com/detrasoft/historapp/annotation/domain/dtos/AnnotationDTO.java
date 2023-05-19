package com.detrasoft.historapp.annotation.domain.dtos;

import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "annotations")
public class AnnotationDTO extends GenericRepresentationModelDTO<AnnotationDTO> {

    @JsonView({ResponseView.findAndPersist.class })
    private Long id;

    @JsonView({ResponseView.findAndPersist.class })
    private String title;

    @NotBlank
    @JsonView({ResponseView.findAndPersist.class })
    private String text;

    @JsonView({ResponseView.findAndPersist.class })
    private String tags;

    @JsonView({ ResponseView.persist.class, ResponseView.findById.class})
    private List<CharacterDTO> characters;

    @JsonView({ ResponseView.persist.class, ResponseView.findById.class})
    private List<LocaleDTO> locales;

    @JsonView({ ResponseView.persist.class, ResponseView.findById.class})
    private List<EventDTO> events;

    @JsonView({ ResponseView.persist.class, ResponseView.findById.class})
    private List<CommentDTO> comments;

    @JsonView({ ResponseView.post.class, ResponseView.find.class})
    private Instant createAt;

    @JsonView({ ResponseView.put.class, ResponseView.find.class})
    private Instant updateAt;
}
