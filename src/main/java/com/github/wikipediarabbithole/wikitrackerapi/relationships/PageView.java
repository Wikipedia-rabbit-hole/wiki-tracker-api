package com.github.wikipediarabbithole.wikitrackerapi.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.entities.Page;
import com.github.wikipediarabbithole.wikitrackerapi.entities.User;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@RelationshipEntity("VIEWED")
public class PageView {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private UUID id;
    @CreatedDate
    private Instant viewedAt;

    @JsonIgnoreProperties("user")
    @StartNode
    private User user;

    @JsonIgnoreProperties("page")
    @EndNode
    private Page page;
}
