package com.github.wikipediarabbithole.wikitrackerapi.models.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.models.relationships.PageView;
import lombok.Data;
import org.neo4j.driver.internal.shaded.reactor.util.annotation.NonNull;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity("User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @NonNull
    private String id;

    private String name;

    @Index(unique = true)
    private String email;

    @LastModifiedDate
    @ReadOnlyProperty
    private LocalDateTime createdDate;

    @JsonIgnoreProperties("user")
    @Relationship(type = "VIEWED")
    private List<PageView> views = new ArrayList<>();
}
