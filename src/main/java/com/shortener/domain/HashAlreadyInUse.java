package com.shortener.domain;

public final class HashAlreadyInUse extends RuntimeException {
    public HashAlreadyInUse() {
        super("The hash is already in use");
    }
}