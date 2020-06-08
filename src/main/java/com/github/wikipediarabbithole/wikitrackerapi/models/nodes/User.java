package com.github.wikipediarabbithole.wikitrackerapi.models.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.models.relationships.PageView;
import lombok.Data;
import org.neo4j.driver.internal.shaded.reactor.util.annotation.NonNull;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @NonNull
    private String id;
    private String name;
    private String email;
    @CreatedDate
    private LocalDateTime createdDate;

    @JsonIgnoreProperties("user")
    @Relationship(type = "VIEWED")
    private List<PageView> views = new ArrayList<>();
}
