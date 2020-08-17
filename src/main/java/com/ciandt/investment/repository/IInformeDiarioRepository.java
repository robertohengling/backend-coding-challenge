package com.ciandt.investment.repository;

import com.ciandt.investment.core.domain.EMes;
import com.ciandt.investment.core.domain.InformeDiario;

import java.util.List;

public interface IInformeDiarioRepository {
    List<InformeDiario> finadAllByMes(EMes mes);
}
