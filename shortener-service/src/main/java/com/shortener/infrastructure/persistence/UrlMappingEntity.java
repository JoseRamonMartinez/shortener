package com.shortener.infrastructure.persistence;

import com.shortener.domain.UrlMapping;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;


@Document(collection = "url-mapping")
public class UrlMappingEntity {

    @Indexed(unique = true)
    private String hash;
    private String origin;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public UrlMappingEntity(String origin, String hash, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.origin = origin;
        this.hash = hash;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getHash() {
        return this.hash;
    }

    public String getOrigin() {
        return this.origin;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return this.expirationDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
                this.origin,
                this.hash,
                this.creationDate,
                this.expirationDate
        );
    }

    public static UrlMappingEntity fromDomain(UrlMapping urlMapping) {
        return new UrlMappingEntity(
                urlMapping.getOrigin(),
                urlMapping.getHash(),
                urlMapping.getCreationDate(),
                urlMapping.getExpirationDate()
        );
    }
}
