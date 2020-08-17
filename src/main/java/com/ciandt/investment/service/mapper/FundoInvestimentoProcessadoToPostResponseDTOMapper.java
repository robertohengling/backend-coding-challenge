package com.ciandt.investment.service.mapper;

import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.v1.rs.response.PostAnalisarFundosInvestimentoResponseDTO;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FundoInvestimentoProcessadoToPostResponseDTOMapper {
    public List<PostAnalisarFundosInvestimentoResponseDTO> map(List<FundoInvestimentoProcessado> fundos){
        if(CollectionUtils.isEmpty(fundos)){
            return Collections.emptyList();
        }

        return fundos.stream()
                .map(f -> new PostAnalisarFundosInvestimentoResponseDTO(f.getCnpjFundo(), f.getCaptacaoLiquida()))
                .collect(Collectors.toList());
    }
}
