package com.shortener.infrastructure.persistence;

import com.shortener.domain.UrlMapping;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "url-mapping")
public class UrlMappinEntity {

    @Id
    private String hash;
    private String originalUrl;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public UrlMappinEntity(String originalUrl, String hash, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.originalUrl = originalUrl;
        this.hash = hash;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getHash() {
        return this.hash;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return this.expirationDate;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public UrlMapping toDomain() {
        return new UrlMapping(
                this.originalUrl,
                this.hash,
                this.creationDate,
                this.expirationDate
        );
    }

    public static UrlMappinEntity fromDomain(UrlMapping urlMapping) {
        return new UrlMappinEntity(
                urlMapping.getOriginalUrl(),
                urlMapping.getHash(),
                urlMapping.getCreationDate(),
                urlMapping.getExpirationDate()
        );
    }
}
