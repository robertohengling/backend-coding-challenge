package com.ciandt.investment.service.validator;

import com.ciandt.investment.core.domain.EMes;
import com.ciandt.investment.core.domain.exception.EInvestimentoErrorCode;
import com.ciandt.investment.core.domain.exception.MesInvalidoException;

public class ProcessadorFundosValidator {

    public void validate(String mes){
        try{
            EMes.valueOf(mes);
        }catch (IllegalArgumentException ex){
            throw new MesInvalidoException(EInvestimentoErrorCode.MES_INVALIDO);
        }
    }
}
