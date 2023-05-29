package com.detrasoft.historapp.annotation.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "annotation")
public class Annotation extends AuditedGenericEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String text;

    @Column(nullable = true)
    private String tags;

    @ElementCollection
    @CollectionTable(name = "characters_annotation", joinColumns = @JoinColumn(name = "annotation_id", foreignKey = @ForeignKey(name = "fk1_characters_annotation")))
    @Column(name = "character_id")
    private List<Long> charactersIds;

    @ElementCollection
    @CollectionTable(name = "locales_annotation", joinColumns = @JoinColumn(name = "annotation_id", foreignKey = @ForeignKey(name = "fk1_locales_annotation")))
    @Column(name = "locale_id")
    private List<Long> localesIds;

    @ElementCollection
    @CollectionTable(name = "events_annotation", joinColumns = @JoinColumn(name = "annotation_id", foreignKey = @ForeignKey(name = "fk1_events_annotation")))
    @Column(name = "locale_id")
    private List<Long> eventsIds;

    @OneToMany(mappedBy = "annotation", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();
}
