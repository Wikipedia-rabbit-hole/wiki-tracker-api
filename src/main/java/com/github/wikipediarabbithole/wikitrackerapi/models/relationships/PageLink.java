package com.github.wikipediarabbithole.wikitrackerapi.models.relationships;

import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.Page;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@RelationshipEntity("LINKED")
public class PageLink {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private UUID id;
    @CreatedDate
    private Instant firstRecordedViewDateTime;
    @LastModifiedDate
    private Instant lastViewDateTime;

    @StartNode
    private Page origin;

    @EndNode
    private Page destination;
}
