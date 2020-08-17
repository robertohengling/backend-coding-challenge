package com.ciandt.investment.core.domain;

public class FundoInvestimentoProcessado {

    private final String cnpjFundo;

    private final Long captacaoLiquida;

    public FundoInvestimentoProcessado(String cnpjFundo, Long captacaoLiquida) {
        this.cnpjFundo = cnpjFundo;
        this.captacaoLiquida = captacaoLiquida;
    }

    public String getCnpjFundo() {
        return cnpjFundo;
    }

    public Long getCaptacaoLiquida() {
        return captacaoLiquida;
    }
}
