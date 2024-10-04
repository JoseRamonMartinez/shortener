package com.shortener.domain;

import java.util.Objects;

public class Url {
    private String value;
    private static final String URL_REGEX = "^(https?:\\/\\/)?([\\w\\d-]+\\.)+[\\w]{2,}(\\/.*)?$";

    public Url(String value) {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.validUrlRegExp(value);
    }

    private void ensureValueIsDefined(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
    }

    private void validUrlRegExp(String value) {
        if (!value.matches(URL_REGEX)) {
            throw new IllegalArgumentException("Value is not a valid URL");
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
        Url url = (Url) o;
        return Objects.equals(value, url.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
