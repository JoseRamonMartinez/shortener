package com.shortener.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UrlMappingTest {

    @Test
    void shouldCreate_whenValidValues() {
        String origin = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        UrlMapping urlMapping = new UrlMapping(origin, hash, creationDate, expirationDate);
        assert urlMapping.getOrigin().equals(origin);
        assert urlMapping.getHash().equals(hash);
        assert urlMapping.getCreationDate().equals(creationDate);
        assert urlMapping.getExpirationDate().equals(expirationDate);
    }

    @Test
    void shouldThrow_whenNullorigin() {
        String origin = null;
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenEmptyorigin() {
        String origin = "";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

   @Test
    void shouldThrow_whenIvalidorigin() {
        String origin = "htaa//www.google.c";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
   }

    @Test
    void shouldThrow_whenNullHash() {
        String origin = "https://www.google.com";
        String hash = null;
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenEmptyHash() {
        String origin = "https://www.google.com";
        String hash = "";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenIvalidHash() {
        String origin = "https://www.google.com";
        String hash = "Y8hF8F";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenNullCreationDate() {
        String origin = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = null;
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenNullExpirationDate() {
        String origin = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = null;
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

    @Test
    void shouldThrow_whenFutureExpirationDate() {
        String origin = "https://www.google.com";
        String hash = "Y8hF8Fh";
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime expirationDate = LocalDateTime.now().minusDays(1);
        assertThrows(IllegalArgumentException.class, () -> new UrlMapping(origin, hash, creationDate, expirationDate));
    }

}
