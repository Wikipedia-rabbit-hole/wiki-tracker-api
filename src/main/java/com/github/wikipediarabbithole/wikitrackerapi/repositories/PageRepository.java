package com.github.wikipediarabbithole.wikitrackerapi.repositories;

import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface PageRepository extends Neo4jRepository<Page, UUID> {
}
