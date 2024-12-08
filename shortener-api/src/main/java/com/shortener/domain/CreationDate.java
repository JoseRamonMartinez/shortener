package com.shortener.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CreationDate implements Serializable {
    private LocalDateTime value;

    public CreationDate(LocalDateTime value) {
         this.value = value;
         this.ensureValueIsDefined(value);
     }

     private void ensureValueIsDefined(LocalDateTime value) {
         if (value == null) {
             throw new IllegalArgumentException("Value cannot be null");
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
        CreationDate creationDate = (CreationDate) o;
        return Objects.equals(value, creationDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
