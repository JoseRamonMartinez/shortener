package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .status(HttpStatus.CREATED)
                .body(new ShortenResponse(response));

    }

}
