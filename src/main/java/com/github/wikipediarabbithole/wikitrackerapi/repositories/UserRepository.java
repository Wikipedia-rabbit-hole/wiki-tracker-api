package com.github.wikipediarabbithole.wikitrackerapi.repositories;

import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, UUID> {
    User findFirstByNameOrderByIdDesc(String name);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
