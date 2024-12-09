package com.shortener.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UrlMapping implements Serializable {
    private Url origin;
    private Hash hash;
    private CreationDate creationDate;
    private ExpirationDate expirationDate;

    public UrlMapping(String origin, String hash, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.origin = new Url(origin);
        this.hash = new Hash(hash);
        this.creationDate = new CreationDate(creationDate);
        this.expirationDate = new ExpirationDate(expirationDate);
    }

    public String getHash() {
        return this.hash.getValue();
    }

    public String getOrigin() {
        return this.origin.getValue();
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

    public void setOrigin(String origin) {
        this.origin = new Url(origin);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = new CreationDate(creationDate);
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = new ExpirationDate(expirationDate);
    }
}
