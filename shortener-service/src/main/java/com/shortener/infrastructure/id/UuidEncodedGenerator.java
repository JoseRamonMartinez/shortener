package com.shortener.infrastructure.id;

import com.shortener.domain.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidEncodedGenerator implements IdGenerator {

    @Override
    public String generate() {
        UUID uuid = UUID.randomUUID();
        return this.encodeBase62(uuid.toString().getBytes());
    }

    private String encodeBase62(byte[] input) {
        String base62Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder encoded = new StringBuilder();
        for (byte b : input) {
            encoded.append(base62Chars.charAt(b % 62));
        }
        return encoded.substring(0, 7);
    }
}
