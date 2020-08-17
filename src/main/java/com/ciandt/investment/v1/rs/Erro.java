package com.ciandt.investment.v1.rs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Erro {

    @JsonProperty
    private final String errorCode;

    public Erro(String errorCode) {
        this.errorCode = errorCode;
    }
}
