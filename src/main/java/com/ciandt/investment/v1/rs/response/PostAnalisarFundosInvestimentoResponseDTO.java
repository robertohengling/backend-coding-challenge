package com.ciandt.investment.v1.rs.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAnalisarFundosInvestimentoResponseDTO {

    @JsonProperty
    private String cnpjFundoInvestimento;

    @JsonProperty
    private Long captacaoLiquida;

    public PostAnalisarFundosInvestimentoResponseDTO(String cnpjFundoInvestimento, Long captacaoLiquida) {
        this.cnpjFundoInvestimento = cnpjFundoInvestimento;
        this.captacaoLiquida = captacaoLiquida;
    }
}
