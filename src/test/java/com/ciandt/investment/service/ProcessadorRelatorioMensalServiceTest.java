package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.FundoInvestimentoProcessadoBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorRelatorioMensalServiceTest {

    @Test
    public void processarTest(){
        IProcessadorRelatorioMensalService processadorRelatorioMensalService = new ProcessadorRelatorioMensalService();
        List<FundoInvestimentoProcessado> fundosInvestimento = processadorRelatorioMensalService.obterRelatorioPrincipaisFundos(getFundos());
        Assert.assertEquals(225000l, fundosInvestimento.get(0).getCaptacaoLiquida().longValue());
    }

    private List<FundoInvestimentoProcessado> getFundos(){
        List<FundoInvestimentoProcessado> informesDiarios = new ArrayList<>();
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("aa").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("bb").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("cc").setCaptacaoLiquida(225000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("dd").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("ee").setCaptacaoLiquida(125000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("ff").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("gg").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("hh").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("ii").setCaptacaoLiquida(95000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("jj").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("kk").setCaptacaoLiquida(55000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("ll").setCaptacaoLiquida(85000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("mm").setCaptacaoLiquida(75000l).createFundoInvestimentoProcessado());
        informesDiarios.add(new FundoInvestimentoProcessadoBuilder().setCnpjFundo("nn").setCaptacaoLiquida(155000l).createFundoInvestimentoProcessado());
        return informesDiarios;
    }

}
