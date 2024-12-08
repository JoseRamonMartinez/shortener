package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Shorten")
@RestController
public class ShortenPostController {

    private final ShorUrlCreator shorUrlCreator;

    public ShortenPostController(ShorUrlCreator shorUrlCreator) {
        this.shorUrlCreator = shorUrlCreator;
    }

    @Operation(summary = "Shorten URL")
    @Parameter(name = "origin", description = "URL to shorten", example = "https://www.google.com", required = true)
    @PostMapping("/shorten")
    public ResponseEntity<ShortenResponse> index(@RequestBody ShortenRequest request) {
        var response = shorUrlCreator.create(request.getOrigin());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ShortenResponse(response));

    }

}
