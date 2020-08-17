package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessadorRelatorioMensalService implements IProcessadorRelatorioMensalService {

    public List<FundoInvestimentoProcessado> obterRelatorioPrincipaisFundos(List<FundoInvestimentoProcessado> relatoriosDoMes){
        Collections.sort(relatoriosDoMes, (r1, r2) -> r2.getCaptacaoLiquida().compareTo(r1.getCaptacaoLiquida()));
        return relatoriosDoMes.stream()
                .limit(10)
                .collect(Collectors.toList());
    }


}
