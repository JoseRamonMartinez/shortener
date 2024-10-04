package com.shortener.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlMappingMongoRepository extends MongoRepository<UrlMappinEntity, String> {
    Optional<UrlMappinEntity> findByHash(String hash);
}
