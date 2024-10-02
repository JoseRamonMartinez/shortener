package com.shortener.application;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class RedirectResolver {

    private final UrlMappingRepository urlMappingRepository;

    public RedirectResolver(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String resolve(String hash) {
        UrlMapping urlMapping = this.urlMappingRepository.findByHash(new Hash(hash));
        return urlMapping.getOriginalUrl();
    }
}
