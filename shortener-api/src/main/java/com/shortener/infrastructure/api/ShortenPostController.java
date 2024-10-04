package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import com.shortener.domain.HashAlreadyInUse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
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
