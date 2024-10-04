package com.shortener.domain;

public class RedirectNotFound extends RuntimeException {
    public RedirectNotFound() {
        super("Redirect not found");
    }
}
