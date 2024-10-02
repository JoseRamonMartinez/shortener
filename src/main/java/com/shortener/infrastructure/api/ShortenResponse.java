package com.shortener.infrastructure.api;

public class ShortenResponse {
    String url;

    public ShortenResponse() {
    }

    public ShortenResponse(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
