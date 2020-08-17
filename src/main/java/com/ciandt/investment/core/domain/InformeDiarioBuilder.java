package com.ciandt.investment.core.domain;

import java.math.BigDecimal;

public class InformeDiarioBuilder {
    private String csvLine;
    private String cnpj;
    private String dataCompetencia;
    private BigDecimal valorTotal;
    private BigDecimal valorCota;
    private BigDecimal valorPatrimonioLiquido;
    private BigDecimal captacaoDia;
    private BigDecimal resgateDia;
    private Integer numeroCotistas;

    public InformeDiarioBuilder setCsvLine(String csvLine) {
        this.csvLine = csvLine;
        return this;
    }

    public InformeDiarioBuilder setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public InformeDiarioBuilder setDataCompetencia(String dataCompetencia) {
        this.dataCompetencia = dataCompetencia;
        return this;
    }

    public InformeDiarioBuilder setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public InformeDiarioBuilder setValorCota(BigDecimal valorCota) {
        this.valorCota = valorCota;
        return this;
    }

    public InformeDiarioBuilder setValorPatrimonioLiquido(BigDecimal valorPatrimonioLiquido) {
        this.valorPatrimonioLiquido = valorPatrimonioLiquido;
        return this;
    }

    public InformeDiarioBuilder setCaptacaoDia(BigDecimal captacaoDia) {
        this.captacaoDia = captacaoDia;
        return this;
    }

    public InformeDiarioBuilder setResgateDia(BigDecimal resgateDia) {
        this.resgateDia = resgateDia;
        return this;
    }

    public InformeDiarioBuilder setNumeroCotistas(Integer numeroCotistas) {
        this.numeroCotistas = numeroCotistas;
        return this;
    }

    public InformeDiario createInformeDiario() {
        return new InformeDiario(cnpj, dataCompetencia, valorTotal, valorCota,
                valorPatrimonioLiquido, captacaoDia, resgateDia, numeroCotistas);
    }
}