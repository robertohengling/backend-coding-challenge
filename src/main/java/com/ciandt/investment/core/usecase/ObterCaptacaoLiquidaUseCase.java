package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeMensal;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObterCaptacaoLiquidaUseCase {

    private final InformeDiarioBoundary informeDiarioBoundary;
    List<InformeMensal> informesMensais;


    public ObterCaptacaoLiquidaUseCase(InformeDiarioBoundary informeDiarioBoundary) {
        this.informeDiarioBoundary = informeDiarioBoundary;
    }

    public void setInformesMensais(List<InformeMensal> informesMensais) {
        this.informesMensais = informesMensais;
    }

    public List<InformeMensal> obtemMelhoresFundos(){


        InformeMensalGenerator informeMensalGenerator = new InformeMensalGenerator(informeDiarioBoundary.getAll());

        informesMensais = informesMensais == null ? informeMensalGenerator.generate() : informesMensais;

        Collections.sort(informesMensais, new InformeMensalComparator());


        return informesMensais.stream().limit(10).collect(Collectors.toList());

    }

}
