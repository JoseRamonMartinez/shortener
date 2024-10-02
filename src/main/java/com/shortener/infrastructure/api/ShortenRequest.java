package com.shortener.infrastructure.api;

public class ShortenRequest {
    String url;

    public ShortenRequest() {
    }

    public ShortenRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
