package com.shortener.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UrlMappingTest {

    @Test
    void shouldCreate_whenValidValues() {
        String originalUrl = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        UrlMapping urlMapping = new UrlMapping(originalUrl, hash, creationDate, expirationDate);
        assert urlMapping.getOriginalUrl().equals(originalUrl);
        assert urlMapping.getHash().equals(hash);
        assert urlMapping.getCreationDate().equals(creationDate);
        assert urlMapping.getExpirationDate().equals(expirationDate);
    }

    @Test
    void shouldThrow_whenNullOriginalUrl() {
        String originalUrl = null;
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenEmptyOriginalUrl() {
        String originalUrl = "";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

   @Test
    void shouldThrow_whenIvalidOriginalUrl() {
        String originalUrl = "htaa//www.google.c";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
   }

    @Test
    void shouldThrow_whenNullHash() {
        String originalUrl = "https://www.google.com";
        String hash = null;
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenEmptyHash() {
        String originalUrl = "https://www.google.com";
        String hash = "";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenIvalidHash() {
        String originalUrl = "https://www.google.com";
        String hash = "Y8hF8F";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenNullCreationDate() {
        String originalUrl = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = null;
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenNullExpirationDate() {
        String originalUrl = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = null;
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenFutureExpirationDate() {
        String originalUrl = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().minusDays(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(originalUrl, hash, creationDate, expirationDate));
    }

}
