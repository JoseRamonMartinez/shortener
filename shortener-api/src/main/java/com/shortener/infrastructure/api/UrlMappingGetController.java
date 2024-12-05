package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShortenGetController {

    private final  short;

    public ShortenGetController(ShorUrlCreator shortUrlCreator) {
        this.shortUrlCreator = shortUrlCreator;
    }

    @GetMapping("/shorten")
    public ResponseEntity<ShortenResponse> index(UrlMappingFilter filter) {
        List<UrlMapping> urlMappings = shortUrlCreator
        var response = shortUrlCreator.create(request.getUrl());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ShortenResponse(response));

    }

}
