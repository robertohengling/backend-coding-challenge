package com.ciandt.investment.v1.rs.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAnalisarFundosInvestimentoRequestDTO {

    @JsonProperty("mes")
    private String mes;

    public String getMes() {
        return mes;
    }
}
