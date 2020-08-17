package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessadorInformesDiariosService implements IProcessadorInformesDiariosService{

    public List<FundoInvestimentoProcessado> processar(List<InformeDiario> informesDiarios){
        if(CollectionUtils.isEmpty(informesDiarios)){
            return Collections.emptyList();
        }
        List<FundoInvestimentoProcessado> fundosInvestimento = new ArrayList<>();
        informesDiarios.stream()
                .collect(Collectors.groupingBy(i -> i.getCnpj(),
                        Collectors.summingLong(i->(i.getCaptacaoDia().longValue() - i.getResgateDia().longValue()))))
                .forEach((cnpj, captacaoLiquida) -> fundosInvestimento.add(new FundoInvestimentoProcessado(cnpj, captacaoLiquida)));

        return fundosInvestimento;
    }


}
