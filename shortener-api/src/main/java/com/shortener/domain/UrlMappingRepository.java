package com.shortener.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UrlMappingRepository {
    Optional<UrlMapping> save(UrlMapping urlMapping);
    Optional<UrlMapping> findByHash(Hash hash);
    Page<UrlMapping> find(UrlMappingFilter filter);
}
