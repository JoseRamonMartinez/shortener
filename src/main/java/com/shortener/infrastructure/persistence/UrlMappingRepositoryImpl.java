package com.shortener.infrastructure.persistence;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UrlMappingRepositoryImpl implements UrlMappingRepository {

    private final UrlMappingMongoRepository urlMappingMongoRepository;

    public UrlMappingRepositoryImpl(UrlMappingMongoRepository urlMappingMongoRepository) {
        this.urlMappingMongoRepository = urlMappingMongoRepository;
    }

    @Override
    public void save(UrlMapping urlMapping) {
        UrlMappinEntity urlMappinEntity = UrlMappinEntity.fromDomain(urlMapping);
        this.urlMappingMongoRepository.save(urlMappinEntity);
    }

    @Override
    public UrlMapping findByHash(Hash hash) {
        UrlMappinEntity urlMappingEntity = this.urlMappingMongoRepository.findByHash(hash.getValue());
        return urlMappingEntity.toDomain();
    }
}
