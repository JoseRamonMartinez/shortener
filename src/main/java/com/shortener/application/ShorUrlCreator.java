package com.shortener.application;

import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ShorUrlCreator {

    private final UrlMappingRepository urlMappingRepository;

    public ShorUrlCreator(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }


    //TODO: Improve with each node have a range of ids for hashing
    public String create(String url) {
        String hash = this.encodeBase62(UUID.randomUUID().toString().getBytes());
        UrlMapping urlMapping = new UrlMapping(url, hash, LocalDateTime.now(), LocalDateTime.now().plusYears(1));
        this.urlMappingRepository.save(urlMapping);
        return urlMapping.getHash();
    }

    private String encodeBase62(byte[] input) {
        String base62Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder encoded = new StringBuilder();
        for (byte b : input) {
            encoded.append(base62Chars.charAt(b % 62));
        }
        return encoded.substring(0, 7);
    }
}
