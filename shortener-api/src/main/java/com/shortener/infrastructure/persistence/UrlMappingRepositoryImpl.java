package com.shortener.infrastructure.persistence;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UrlMappingRepositoryImpl implements UrlMappingRepository {

    private final UrlMappingMongoRepository urlMappingMongoRepository;

    public UrlMappingRepositoryImpl(UrlMappingMongoRepository urlMappingMongoRepository) {
        this.urlMappingMongoRepository = urlMappingMongoRepository;
    }

    @CachePut(value = "UrlMappings", key = "#urlMapping.hash")
    @Override
    public Optional<UrlMapping> save(UrlMapping urlMapping) {
        UrlMappingEntity urlMappingEntity = UrlMappingEntity.fromDomain(urlMapping);
        try {
            this.urlMappingMongoRepository.save(urlMappingEntity);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(urlMapping);
    }

    @Cacheable(value = "UrlMappings", key = "#hash")
    @Override
    public Optional<UrlMapping> findByHash(Hash hash) {
        return this.urlMappingMongoRepository.findByHash(hash.getValue())
                .map(UrlMappingEntity::toDomain);
    }

}
