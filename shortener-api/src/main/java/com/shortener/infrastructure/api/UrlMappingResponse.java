package com.shortener.infrastructure.api;

import java.time.LocalDateTime;
import java.util.List;

public class UrlMappingResponse {

    private List<UrlMappingPage> content;
    private int totalPages;
    private long totalElements;

    public UrlMappingResponse(List<UrlMappingPage> content, int totalPages, long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }


    public List<UrlMappingPage> getContent() {
        return content;
    }

    public void setContent(List<UrlMappingPage> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public static class UrlMappingPage {
        private String hash;
        private LocalDateTime creationDate;

        public UrlMappingPage(String hash, LocalDateTime creationDate) {
            this.hash = hash;
            this.creationDate = creationDate;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public LocalDateTime getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
        }
    }
}