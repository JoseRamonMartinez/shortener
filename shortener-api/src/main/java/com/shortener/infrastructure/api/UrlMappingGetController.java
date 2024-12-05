package com.shortener.infrastructure.api;

import com.shortener.application.UrlMappingFinder;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlMappingGetController {

    private final UrlMappingFinder urlMappingFinder;

    public UrlMappingGetController(UrlMappingFinder urlMappingFinder) {
        this.urlMappingFinder = urlMappingFinder;
    }

    @GetMapping("/url-mapping")
    public ResponseEntity<UrlMappingResponse> index(UrlMappingFilter filter, Pageable pageable) {
        filter.setPageable(pageable);
        Page<UrlMapping> urlMappingPage = urlMappingFinder.find(filter);
        List<UrlMappingResponse.UrlMappingPage> content = urlMappingPage.getContent().stream()
                .map(urlMapping -> new UrlMappingResponse.UrlMappingPage(urlMapping.getHash(), urlMapping.getCreationDate()))
                .toList();
        UrlMappingResponse response = new UrlMappingResponse(content, urlMappingPage.getTotalPages(), urlMappingPage.getTotalElements());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

}
