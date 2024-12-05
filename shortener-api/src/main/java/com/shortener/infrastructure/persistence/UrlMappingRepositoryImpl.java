package com.shortener.infrastructure.persistence;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UrlMappingRepositoryImpl implements UrlMappingRepository {

    private final UrlMappingMongoRepository urlMappingMongoRepository;

    private final MongoTemplate mongoTemplate;

    public UrlMappingRepositoryImpl(UrlMappingMongoRepository urlMappingMongoRepository, MongoTemplate mongoTemplate) {
        this.urlMappingMongoRepository = urlMappingMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

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

    @Override
    public Optional<UrlMapping> findByHash(Hash hash) {
        return this.urlMappingMongoRepository.findByHash(hash.getValue())
                .map(UrlMappingEntity::toDomain);
    }

    @Override
    public Page<UrlMapping> find(UrlMappingFilter filter) {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        if (Boolean.FALSE.equals(filter.getIsExpired())) {
            criteria.and("expirationDate").gt(LocalDateTime.now());
        }
        query.with(filter.getPageable());
        List<UrlMappingEntity> urlMappings = mongoTemplate.find(query, UrlMappingEntity.class);
        long total = mongoTemplate.count(query, UrlMappingEntity.class);
        return new PageImpl<>(urlMappings.stream().map(UrlMappingEntity::toDomain).collect(Collectors.toList()), filter.getPageable(), total);
    }
}
