package com.shortener.infrastructure.api;


import com.shortener.application.RedirectResolver;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Tag(name = "Redirect")
@RestController
public class RedirectGetController {

    private RedirectResolver redirectResolver;

    public RedirectGetController(RedirectResolver redirectResolver) {
        this.redirectResolver = redirectResolver;
    }

    @Operation(summary = "Redirect to URL")
    @Parameter(name = "hash", description = "Hash to redirect", example = "Y8hF8Fh", required = true)
    @GetMapping("/{hash}")
    public ResponseEntity<?> index(@PathVariable String hash) {
        var response = redirectResolver.resolve(hash);
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(response))
                .header(HttpHeaders.CONNECTION, "close")
                .build();
    }

}
