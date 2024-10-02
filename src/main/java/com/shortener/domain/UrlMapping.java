package com.shortener.domain;

import java.time.LocalDateTime;

public class UrlMapping {
    private Url originalUrl;
    private Hash hash;
    private CreationDate creationDate;
    private ExpirationDate expirationDate;

    public UrlMapping(String originalUrl, String hash, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.originalUrl = new Url(originalUrl);
        this.hash = new Hash(hash);
        this.creationDate = new CreationDate(creationDate);
        this.expirationDate = new ExpirationDate(expirationDate);
    }

    public String getHash() {
        return this.hash.getValue();
    }

    public String getOriginalUrl() {
        return this.originalUrl.getValue();
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate.getValue();
    }

    public LocalDateTime getExpirationDate() {
        return this.expirationDate.getValue();
    }

    public void setHash(String hash) {
        this.hash = new Hash(hash);
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = new Url(originalUrl);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = new CreationDate(creationDate);
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = new ExpirationDate(expirationDate);
    }
}
