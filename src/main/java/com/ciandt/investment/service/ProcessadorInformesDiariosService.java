package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessadorInformesDiariosService implements IProcessadorInformesDiariosService{

    public List<FundoInvestimentoProcessado> processar(List<InformeDiario> informesDiarios){
        if(CollectionUtils.isEmpty(informesDiarios)){
            return Collections.emptyList();
        }

        informesDiarios.stream()
                .collect(Collectors.groupingBy(i -> i.getCnpj(),
                        Collectors.summingDouble(i->(i.getCaptacaoDia().doubleValue() - i.getResgateDia().doubleValue()))))
                .forEach((cnpg, captacaoLiquida) -> System.out.println("" + cnpg + " captacaoLiquida" + captacaoLiquida));

        return Collections.emptyList();
    }


}
