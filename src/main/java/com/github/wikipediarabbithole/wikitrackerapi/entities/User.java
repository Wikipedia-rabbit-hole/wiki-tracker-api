package com.github.wikipediarabbithole.wikitrackerapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.wikipediarabbithole.wikitrackerapi.relationships.PageView;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;
    private String name;
    private String email;

    @JsonIgnoreProperties("user")
    @Relationship(type = "VIEWED")
    private List<PageView> views = new ArrayList<>();
}
