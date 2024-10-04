package com.shortener.application;

import com.shortener.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShorUrlCreator {

    private final UrlMappingRepository urlMappingRepository;

    private final IdGenerator idGenerator;

    private static final int EXPIRATION_TIME_IN_DAYS = 365;

    public ShorUrlCreator(UrlMappingRepository urlMappingRepository, IdGenerator idGenerator) {
        this.urlMappingRepository = urlMappingRepository;
        this.idGenerator = idGenerator;
    }

    public String create(String url) {
        String hash = this.idGenerator.generate();
        var creationDate = LocalDateTime.now();
        var expirationDate = LocalDateTime.now().plusDays(EXPIRATION_TIME_IN_DAYS);
        UrlMapping urlMapping = new UrlMapping(url, hash, creationDate, expirationDate);
        return this.urlMappingRepository.save(urlMapping)
                        .map(UrlMapping::getHash)
                        .orElseThrow(HashAlreadyInUse::new);
    }
}
