package com.ciandt.investment.service;

import com.ciandt.investment.v1.rs.response.PostAnalisarFundosInvestimentoResponseDTO;

import java.util.List;

public interface IProcessadorFundosService {

    List<PostAnalisarFundosInvestimentoResponseDTO> processarAnaliseMensal(String mes);
}
