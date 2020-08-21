package com.ciandt.investment.core.domain;

import java.math.BigDecimal;

public class InformeMensal {

    private String cnpj;
    private BigDecimal captacaoLiquida;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getCaptacaoLiquida() {
        return captacaoLiquida;
    }

    public void setCaptacaoLiquida(BigDecimal captacaoLiquida) {
        this.captacaoLiquida = captacaoLiquida;
    }
}
