package com.ciandt.investment.v1.rs;

import com.ciandt.investment.service.IProcessadorFundosService;
import com.ciandt.investment.v1.rs.request.PostAnalisarFundosInvestimentoRequestDTO;
import com.ciandt.investment.v1.rs.response.PostAnalisarFundosInvestimentoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class ProcessadorFundosV1RS {

    private final IProcessadorFundosService processadorFundosService;

    public ProcessadorFundosV1RS(IProcessadorFundosService processadorFundosService) {
        this.processadorFundosService = processadorFundosService;
    }

    @RequestMapping(value = "/analiseMensal", method = {RequestMethod.POST})
    public ResponseEntity<List<PostAnalisarFundosInvestimentoResponseDTO>>  analisarFundosInvestimento(
            @RequestBody final PostAnalisarFundosInvestimentoRequestDTO requestBodyDTO){
        List<PostAnalisarFundosInvestimentoResponseDTO> responseDTO = processadorFundosService
                .processarAnaliseMensal(requestBodyDTO.getMes());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
