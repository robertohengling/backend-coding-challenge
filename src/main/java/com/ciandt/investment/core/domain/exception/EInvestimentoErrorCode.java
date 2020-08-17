package com.ciandt.investment.core.domain.exception;

public enum EInvestimentoErrorCode {
    ERRO_INTERNO("E0001"),
    MES_INVALIDO("E0002");

    private final String erroCode;

    EInvestimentoErrorCode(String erroCode) {
        this.erroCode = erroCode;
    }

    public String getErroCode() {
        return erroCode;
    }
}
