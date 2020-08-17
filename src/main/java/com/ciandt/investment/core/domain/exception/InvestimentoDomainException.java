package com.ciandt.investment.core.domain.exception;

public class InvestimentoDomainException extends RuntimeException {

    private final EInvestimentoErrorCode errorCode;

    public InvestimentoDomainException(EInvestimentoErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public EInvestimentoErrorCode getErrorCode() {
        return errorCode;
    }
}
