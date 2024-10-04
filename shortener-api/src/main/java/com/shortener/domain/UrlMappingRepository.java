package com.shortener.domain;

import java.util.Optional;

public interface UrlMappingRepository {
    Optional<UrlMapping> save(UrlMapping urlMapping);

    Optional<UrlMapping> findByHash(Hash hash);
}
