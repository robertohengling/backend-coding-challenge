package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.dataprovider.InformeDiarioGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.junit.Assert.*;

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


}