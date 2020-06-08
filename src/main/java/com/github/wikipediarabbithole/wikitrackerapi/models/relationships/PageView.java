package com.github.wikipediarabbithole.wikitrackerapi.models.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.Page;
import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.User;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@RelationshipEntity("VIEWED")
public class PageView {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;
    @CreatedDate
    private Instant viewedAt;
    // TODO: Revisit data type
    private String sessionId;

    @JsonIgnoreProperties("user")
    @StartNode
    private User user;

    @JsonIgnoreProperties("page")
    @EndNode
    private Page page;
}
