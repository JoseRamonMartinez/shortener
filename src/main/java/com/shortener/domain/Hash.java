package com.shortener.domain;

import java.util.Objects;

public class Hash {
    private String value;
    private static final String HASH_REGEX = "^[a-zA-Z0-9]{7}$";

    public Hash(String value) {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.validHashRegExp(value);
    }

    private void ensureValueIsDefined(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
    }

    private void validHashRegExp(String value) {
        if (!value.matches(HASH_REGEX)) {
            throw new IllegalArgumentException("Hash must be a valid hash");
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hash hash = (Hash) o;
        return Objects.equals(value, hash.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
