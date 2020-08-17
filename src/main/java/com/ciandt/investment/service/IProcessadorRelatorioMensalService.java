package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;

import java.util.List;

public interface IProcessadorRelatorioMensalService {
    List<FundoInvestimentoProcessado> obterRelatorioPrincipaisFundos(List<FundoInvestimentoProcessado> relatoriosDoMes);
}
