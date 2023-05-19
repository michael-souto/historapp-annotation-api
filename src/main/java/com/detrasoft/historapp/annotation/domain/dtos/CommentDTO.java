package com.detrasoft.historapp.annotation.domain.dtos;

import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "comments")
public class CommentDTO extends GenericRepresentationModelDTO<CommentDTO> {

    @JsonView({ResponseView.findAndPersist.class })
    private Long id;

    @NotBlank
    @JsonView({ResponseView.findAndPersist.class })
    private String text;

    @JsonView({ResponseView.findAndPersist.class })
    private Long indexReference;

    @JsonView({ResponseView.findAndPersist.class })
    private Long lengthReference;

    private Long idDetail;
}
