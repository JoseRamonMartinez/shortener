package com.shortener.infrastructure.persistence;

import com.mongodb.MongoWriteException;
import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UrlMappingRepositoryImpl implements UrlMappingRepository {

    private final UrlMappingMongoRepository urlMappingMongoRepository;

    public UrlMappingRepositoryImpl(UrlMappingMongoRepository urlMappingMongoRepository) {
        this.urlMappingMongoRepository = urlMappingMongoRepository;
    }

    @Override
    public Optional<UrlMapping> save(UrlMapping urlMapping) {
        UrlMappinEntity urlMappinEntity = UrlMappinEntity.fromDomain(urlMapping);
        try {
            this.urlMappingMongoRepository.save(urlMappinEntity);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(urlMapping);
    }

    @Override
    public Optional<UrlMapping> findByHash(Hash hash) {
        return this.urlMappingMongoRepository.findByHash(hash.getValue())
                .map(UrlMappinEntity::toDomain);
    }
}
