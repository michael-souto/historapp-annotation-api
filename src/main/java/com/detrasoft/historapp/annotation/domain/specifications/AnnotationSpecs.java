package com.detrasoft.historapp.annotation.domain.specifications;

import com.detrasoft.historapp.annotation.domain.entities.Annotation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AnnotationSpecs {

    public static Specification<Annotation> byTitle(String title) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (title != null && !title.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get("title").as(String.class)),
                                "%" + title.toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Annotation> byText(String text) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (text != null && !text.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get("text").as(String.class)),
                                "%" + text.toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Annotation> byTag(String tag) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (tag != null && !tag.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get("tags").as(String.class)),
                                "%" + tag.toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Annotation> byEvents(List<Long> eventsIds) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (eventsIds != null && eventsIds.size() > 0) {
                predicates.add(root.joinList("eventsIds").in(eventsIds));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Annotation> byCharacters(List<Long> charactersIds) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (charactersIds != null && charactersIds.size() > 0) {
                predicates.add(root.joinList("charactersIds").in(charactersIds));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Annotation> byLocales(List<Long> localesIds) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (localesIds != null && localesIds.size() > 0) {
                predicates.add(root.joinList("localesIds").in(localesIds));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
    public static Specification<Annotation> byAllFields(String word) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (word != null && !word.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get("tags").as(String.class)),
                                "%" + word.toLowerCase() + "%"));
                predicates.add(
                        builder.like(
                                builder.lower(root.get("text").as(String.class)),
                                "%" + word.toLowerCase() + "%"));
                predicates.add(
                        builder.like(
                                builder.lower(root.get("title").as(String.class)),
                                "%" + word.toLowerCase() + "%"));
            }
            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }
}