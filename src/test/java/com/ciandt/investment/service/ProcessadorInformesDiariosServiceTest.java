package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.core.domain.InformeDiarioBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorInformesDiariosServiceTest {

    @Test
    public void processarSomaCaptacaoLiquidaDeveSerValidaAgrupandoPorCnpj(){
        IProcessadorInformesDiariosService processadorInformesDiariosService = new ProcessadorInformesDiariosService();

        List<FundoInvestimentoProcessado> fundosInvestimento = processadorInformesDiariosService.processar(getInformes());

        Assert.assertEquals(12l,
                fundosInvestimento.stream()
                        .filter(f -> "a".equals(f.getCnpjFundo()))
                        .findFirst().get().getCaptacaoLiquida().longValue());

        Assert.assertEquals(1l,
                fundosInvestimento.stream()
                        .filter(f -> "b".equals(f.getCnpjFundo()))
                        .findFirst().get().getCaptacaoLiquida().longValue());

        Assert.assertEquals(31l,
                fundosInvestimento.stream()
                        .filter(f -> "d".equals(f.getCnpjFundo()))
                        .findFirst().get().getCaptacaoLiquida().longValue());

    }

    private List<InformeDiario> getInformes(){
        List<InformeDiario> informesDiarios = new ArrayList<>();
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("3")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("b").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("10")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("d").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("d").setCaptacaoDia(new BigDecimal("30")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("d").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        return informesDiarios;
    }

}
