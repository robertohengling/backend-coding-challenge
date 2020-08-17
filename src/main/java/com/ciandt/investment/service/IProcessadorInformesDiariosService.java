package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;

import java.util.List;

public interface IProcessadorInformesDiariosService {
    List<FundoInvestimentoProcessado> processar(List<InformeDiario> informesDiarios);
}
