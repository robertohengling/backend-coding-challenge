package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.core.domain.InformeMensal;
import com.ciandt.investment.dataprovider.InformeDiarioGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ObterCaptacaoLiquidaUseCaseTest {

    private ObterCaptacaoLiquidaUseCase obterCaptacaoLiquidaUseCase;
    private InformeDiarioBoundary informeDiarioBoundary;

    @Before
    public void setup() {
        informeDiarioBoundary = new InformeDiarioGateway();
        obterCaptacaoLiquidaUseCase = new ObterCaptacaoLiquidaUseCase(informeDiarioBoundary);
    }

    @Test
    public void deveObterOsDadosdeInformesDiario() {

        List<InformeDiario> all = informeDiarioBoundary.getAll();
        Assert.assertEquals(325850, all.size());
    }

    @Test
    public void deveObterInformesMensais(){
        List<InformeDiario> informesDiarios = new ArrayList<>();

        new InformeDiario("1", new BigDecimal(100), new BigDecimal(50));
        informesDiarios.add( new InformeDiario("1", new BigDecimal(100), new BigDecimal(50)));
        informesDiarios.add( new InformeDiario("1", new BigDecimal(100), new BigDecimal(70)));

        informesDiarios.add( new InformeDiario("2", new BigDecimal(100), new BigDecimal(40)));
        informesDiarios.add( new InformeDiario("2", new BigDecimal(100), new BigDecimal(90)));

        InformeMensalGenerator informeMensalGenerator = new InformeMensalGenerator(informesDiarios);
        List<InformeMensal> informesMensais = informeMensalGenerator.generate();

        Assert.assertEquals("1", informesMensais.get(0).getCnpj());
        Assert.assertEquals( new BigDecimal(80), informesMensais.get(0).getCaptacaoLiquida());

        Assert.assertEquals("2", informesMensais.get(1).getCnpj());
        Assert.assertEquals(new BigDecimal(70), informesMensais.get(1).getCaptacaoLiquida());
    }

    @Test
    public void deveObterMelhoresInformesMensais(){
        List<InformeDiario> informesDiarios = new ArrayList<>();

        new InformeDiario("1", new BigDecimal(100), new BigDecimal(50));
        informesDiarios.add( new InformeDiario("1", new BigDecimal(100), new BigDecimal(80)));
        informesDiarios.add( new InformeDiario("1", new BigDecimal(100), new BigDecimal(90)));

        informesDiarios.add( new InformeDiario("2", new BigDecimal(100), new BigDecimal(50)));
        informesDiarios.add( new InformeDiario("2", new BigDecimal(100), new BigDecimal(70)));

        InformeMensalGenerator informeMensalGenerator = new InformeMensalGenerator(informesDiarios);
        List<InformeMensal> informesMensais = informeMensalGenerator.generate();


        Assert.assertEquals("1", informesMensais.get(0).getCnpj());
        Assert.assertEquals( new BigDecimal(30), informesMensais.get(0).getCaptacaoLiquida());

        Assert.assertEquals("2", informesMensais.get(1).getCnpj());
        Assert.assertEquals(new BigDecimal(80), informesMensais.get(1).getCaptacaoLiquida());

        obterCaptacaoLiquidaUseCase.setInformesMensais(informesMensais);

        informesMensais = obterCaptacaoLiquidaUseCase.obtemMelhoresFundos();

        Assert.assertEquals("2", informesMensais.get(0).getCnpj());
        Assert.assertEquals( new BigDecimal(80), informesMensais.get(0).getCaptacaoLiquida());

        Assert.assertEquals("1", informesMensais.get(1).getCnpj());
        Assert.assertEquals(new BigDecimal(30), informesMensais.get(1).getCaptacaoLiquida());
    }
}