package com.shortener.infrastructure.api;

public class ShortenRequest {
    String origin;

    public ShortenRequest() {
    }

    public ShortenRequest(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
