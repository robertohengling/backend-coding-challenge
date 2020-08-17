package com.ciandt.investment.core.domain.exception;

public class MesInvalidoException extends InvestimentoDomainException {

    public MesInvalidoException(EInvestimentoErrorCode errorCode) {
        super(errorCode);
    }
}
