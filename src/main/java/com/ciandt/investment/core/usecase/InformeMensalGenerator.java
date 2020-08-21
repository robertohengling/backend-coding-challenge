package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.core.domain.InformeMensal;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class InformeMensalGenerator {
    private List<InformeDiario> informesDiarios;

    public InformeMensalGenerator(List<InformeDiario> informesDiarios){

        this.informesDiarios = informesDiarios;
    }

    public List<InformeMensal> generate(){
        List<InformeMensal> informesMensais = new ArrayList<>();

        Collections.sort(informesDiarios, new InformeDiarioComparator());

        InformeMensal informeMensal = new InformeMensal();

        for (InformeDiario informeDiario : informesDiarios) {

            if (informeMensal.getCnpj() == null){
                informeMensal.setCnpj( informeDiario.getCnpj());
                informeMensal.setCaptacaoLiquida(BigDecimal.ZERO);
            } else if(!informeMensal.getCnpj().equals(informeDiario.getCnpj())){
                informesMensais.add(informeMensal);

                informeMensal = new InformeMensal();
                informeMensal.setCnpj(informeDiario.getCnpj());
                informeMensal.setCaptacaoLiquida(BigDecimal.ZERO);
            }

            informeMensal.setCaptacaoLiquida(informeMensal.getCaptacaoLiquida()
                    .add(informeDiario.getCaptacaoDia().subtract(informeDiario.getResgateDia())));
        }
        informesMensais.add(informeMensal);

        return informesMensais;
    }
}
