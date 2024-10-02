package com.shortener.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlMappingMongoRepository extends MongoRepository<UrlMappinEntity, String> {
    UrlMappinEntity findByHash(String hash);
    UrlMappinEntity save(UrlMappinEntity urlMappinEntity);
}
