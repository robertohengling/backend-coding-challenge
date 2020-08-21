package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.InformeMensal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObterMelhoresInvestimentosController {
    ObterCaptacaoLiquidaUseCase obterCaptacaoLiquidaUseCase;

    public ObterMelhoresInvestimentosController(ObterCaptacaoLiquidaUseCase obterCaptacaoLiquidaUseCase) {
        this.obterCaptacaoLiquidaUseCase = obterCaptacaoLiquidaUseCase;
    }

    @GetMapping(path= "/melhores-investimentos")
    public List<InformeMensal> get(){
        return obterCaptacaoLiquidaUseCase.obtemMelhoresFundos();
    }
}
