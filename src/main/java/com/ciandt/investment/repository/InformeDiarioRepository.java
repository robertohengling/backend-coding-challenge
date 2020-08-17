package com.ciandt.investment.repository;

import com.ciandt.investment.core.domain.EMes;
import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.core.domain.InformeDiarioBuilder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InformeDiarioRepository implements IInformeDiarioRepository {
    @Override
    public List<InformeDiario> finadAllByMes(EMes mes) {
        List<InformeDiario> informesDiarios = new ArrayList<>();
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("3")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("b").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("a").setCaptacaoDia(new BigDecimal("10")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        informesDiarios.add(new InformeDiarioBuilder().setCnpj("d").setCaptacaoDia(new BigDecimal("2")).setResgateDia(new BigDecimal("1")).createInformeDiario());
        return informesDiarios;
    }
}
