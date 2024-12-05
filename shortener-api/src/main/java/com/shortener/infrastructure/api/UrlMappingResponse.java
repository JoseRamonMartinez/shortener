package com.shortener.infrastructure.api;

import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public class UrlMappingPageResponse {

    List<UrlMappingPageResponse> content;

    public UrlMappingPageResponse(List<UrlMappingPageResponse> content, int totalPages, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    int totalPages;

    int totalElements;

    public List<UrlMappingPageResponse> getContent() {
        return content;
    }

    public void setContent(List<UrlMappingPageResponse> content) {
        this.content = content;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public static class UrlMappingPage {
        String hash;

        LocalDateTime creationDate;

        public UrlMappingPage(String hash) {
            this.hash = hash;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
