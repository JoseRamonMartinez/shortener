package com.shortener.domain;

public interface UrlMappingRepository {
    void save(UrlMapping urlMapping);

    UrlMapping findByHash(Hash hash);
}
