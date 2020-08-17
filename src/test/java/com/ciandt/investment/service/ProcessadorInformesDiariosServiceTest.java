package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.core.domain.InformeDiarioBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessadorInformesDiariosServiceTest {

    @Test
    public void processarTest(){
        //IProcessadorInformesDiariosService processadorInformesDiariosService = new ProcessadorInformesDiariosService();
        //List<FundoInvestimentoProcessado> fundosInvestimento = processadorInformesDiariosService.processar(getInformes());
        //Assert.assertEquals("11.0", fundosInvestimento.get(0).getCaptacaoLiquida());

        getInformes().stream()
                .collect(Collectors.groupingBy(i -> i.getCnpj(),
                        Collectors.summingDouble(i->(i.getCaptacaoDia().doubleValue() - i.getResgateDia().doubleValue()))))
                .forEach((cnpg, captacaoLiquida) -> System.out.println("" + cnpg + " captacaoLiquida" + captacaoLiquida));

    }

    private List<InformeDiario> getInformes(){
        List<InformeDiario> informesDiarios = new ArrayList<>();
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("3")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("b").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("10")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("d").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        return informesDiarios;
    }

}
