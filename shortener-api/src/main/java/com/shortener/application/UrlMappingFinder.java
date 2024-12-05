package com.shortener.application;

import com.shortener.domain.UrlMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShortenFinder {

    private final UrlMappingRepository urlMappingRepository;

    public ShortenFinder(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public
}
