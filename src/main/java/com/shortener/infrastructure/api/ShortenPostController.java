package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenPostController {

    private final ShorUrlCreator shorUrlCreator;

    public ShortenPostController(ShorUrlCreator shorUrlCreator) {
        this.shorUrlCreator = shorUrlCreator;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortenResponse> index(@RequestBody ShortenRequest request) {
        var response = shorUrlCreator.create(request.getUrl());
        return ResponseEntity
                .status(201)
                .body(new ShortenResponse(response));

    }

}
