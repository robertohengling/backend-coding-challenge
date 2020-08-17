package com.ciandt.investment.core.domain;

public class FundoInvestimentoProcessadoBuilder {
    private String cnpjFundo;
    private Long captacaoLiquida;

    public FundoInvestimentoProcessadoBuilder setCnpjFundo(String cnpjFundo) {
        this.cnpjFundo = cnpjFundo;
        return this;
    }

    public FundoInvestimentoProcessadoBuilder setCaptacaoLiquida(Long captacaoLiquida) {
        this.captacaoLiquida = captacaoLiquida;
        return this;
    }

    public FundoInvestimentoProcessado createFundoInvestimentoProcessado() {
        return new FundoInvestimentoProcessado(cnpjFundo, captacaoLiquida);
    }
}