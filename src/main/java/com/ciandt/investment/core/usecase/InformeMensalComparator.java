package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeMensal;

import java.util.Comparator;

public class InformeMensalComparator implements Comparator<InformeMensal> {

    @Override
    public int compare(InformeMensal o1, InformeMensal o2) {
        return o2.getCaptacaoLiquida().compareTo(o1.getCaptacaoLiquida());
    }
}
