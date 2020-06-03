package com.github.wikipediarabbithole.wikitrackerapi.repositories;

import com.github.wikipediarabbithole.wikitrackerapi.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, UUID> {
    User findByName(String name);
}
