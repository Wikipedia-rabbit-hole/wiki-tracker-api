package com.github.wikipediarabbithole.wikitrackerapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.relationships.PageLink;
import com.github.wikipediarabbithole.wikitrackerapi.relationships.PageView;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
@Data
public class Page {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private UUID id;
    private String slug;
    private String title;
    private List<String> categories;

    @JsonIgnoreProperties("page")
    @Relationship(type = "VIEWED", direction = INCOMING)
    private List<PageView> views = new ArrayList<>();

    @JsonIgnoreProperties("page")
    @Relationship(type = "LINKED")
    private List<PageLink> outgoingLinks = new ArrayList<>();

    @JsonIgnoreProperties("page")
    @Relationship(type = "LINKED", direction = INCOMING)
    private List<PageLink> incomingLinks = new ArrayList<>();
}
