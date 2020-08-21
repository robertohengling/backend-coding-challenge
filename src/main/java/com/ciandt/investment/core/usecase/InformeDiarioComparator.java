package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeDiario;

import java.util.Comparator;

public class InformeDiarioComparator implements Comparator<InformeDiario> {

    @Override
    public int compare(InformeDiario o1, InformeDiario o2) {
        return o1.getCnpj().compareTo(o2.getCnpj());
    }
}
