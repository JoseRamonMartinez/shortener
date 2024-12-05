package com.shortener.domain;

import org.springframework.data.domain.Pageable;

public class UrlMappingFilter {

    Boolean isExpired;
    String term;
    Pageable pageable;

    public UrlMappingFilter(Boolean isExpired, String term, Pageable pageable) {
        this.pageable = pageable;
        this.isExpired = isExpired;
        this.term = term;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }


}
