package com.github.wikipediarabbithole.wikitrackerapi;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static graphql.Scalars.GraphQLString;

@SpringBootApplication
public class WikiTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiTrackerApiApplication.class, args);
    }

    @Bean
    GraphQLSchema schema() {
        return GraphQLSchema.newSchema()
                .query(GraphQLObjectType.newObject()
                        .name("query")
                        .field(field -> field
                                .name("test")
                                .type(GraphQLString)
                                .dataFetcher(environment -> "response"))
                        .build())
                .build();
    }
}
