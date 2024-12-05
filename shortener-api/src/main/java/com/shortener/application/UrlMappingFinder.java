package com.shortener.application;

import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingFinder {

    private final UrlMappingRepository urlMappingRepository;

    public UrlMappingFinder(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public Page<UrlMapping> find(UrlMappingFilter filter) {
        return urlMappingRepository.find(filter);
    }

}
