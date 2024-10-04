package com.shortener.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExpirationDate {
    private LocalDateTime value;

    public ExpirationDate(LocalDateTime value) {
         this.value = value;
         this.ensureValueIsDefined(value);
         this.validDateInTheFuture(value);
     }

     private void ensureValueIsDefined(LocalDateTime value) {
         if (value == null) {
             throw new IllegalArgumentException("Value cannot be null");
         }
     }

     private void validDateInTheFuture(LocalDateTime value) {
         if (value.isBefore(LocalDateTime.now())) {
             throw new IllegalArgumentException("Value must be in the future");
         }
     }

     public LocalDateTime getValue() {
         return value;
     }

     public void setValue(LocalDateTime value) {
         this.value = value;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpirationDate expirationDate = (ExpirationDate) o;
        return Objects.equals(value, expirationDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
