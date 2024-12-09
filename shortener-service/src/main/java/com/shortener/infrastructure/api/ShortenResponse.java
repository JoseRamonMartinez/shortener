package com.shortener.infrastructure.api;

public class ShortenResponse {
    String hash;

    public ShortenResponse() {
    }

    public ShortenResponse(String hash) {
        this.hash = hash;
    }

    public String gethash() {
        return hash;
    }

    public void sethash(String url) {
        this.hash = url;
    }
}
