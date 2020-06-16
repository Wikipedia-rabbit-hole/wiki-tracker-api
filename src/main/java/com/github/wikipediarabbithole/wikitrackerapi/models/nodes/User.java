package com.github.wikipediarabbithole.wikitrackerapi.models.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.models.relationships.PageView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.driver.internal.shaded.reactor.util.annotation.NonNull;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @NonNull
    private String id;

    private String name;

    @Index(unique = true)
    @EqualsAndHashCode.Include
    private String email;

    @CreatedDate
    @ToString.Exclude
    private LocalDateTime createdDate;

    @JsonIgnoreProperties("user")
    @Relationship(type = "VIEWED")
    private List<PageView> views = new ArrayList<>();
}
