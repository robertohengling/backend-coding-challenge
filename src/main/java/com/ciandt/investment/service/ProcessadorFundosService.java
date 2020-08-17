package com.ciandt.investment.service;

import com.ciandt.investment.core.domain.EMes;
import com.ciandt.investment.core.domain.FundoInvestimentoProcessado;
import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.repository.IInformeDiarioRepository;
import com.ciandt.investment.service.mapper.FundoInvestimentoProcessadoToPostResponseDTOMapper;
import com.ciandt.investment.service.validator.ProcessadorFundosValidator;
import com.ciandt.investment.v1.rs.response.PostAnalisarFundosInvestimentoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessadorFundosService implements IProcessadorFundosService {

    private final IProcessadorInformesDiariosService processadorInformesDiariosService;
    private final IInformeDiarioRepository informeDiarioRepository;
    private final IProcessadorRelatorioMensalService processadorRelatorioMensal;

    public ProcessadorFundosService(IProcessadorInformesDiariosService processadorInformesDiariosService,
                                    IInformeDiarioRepository informeDiarioRepository,
                                    IProcessadorRelatorioMensalService processadorRelatorioMensal) {
        this.processadorInformesDiariosService = processadorInformesDiariosService;
        this.informeDiarioRepository = informeDiarioRepository;
        this.processadorRelatorioMensal = processadorRelatorioMensal;
    }

    @Override
    public List<PostAnalisarFundosInvestimentoResponseDTO> processarAnaliseMensal(String mes) {

        new ProcessadorFundosValidator().validate(mes);
        List<InformeDiario> informesDiarios = informeDiarioRepository.finadAllByMes(EMes.valueOf(mes));
        List<FundoInvestimentoProcessado> fundosProcessados = processadorInformesDiariosService
                .processar(informesDiarios);
        List<FundoInvestimentoProcessado> fundosProcessadosRelatorio = processadorRelatorioMensal
                .obterRelatorioPrincipaisFundos(fundosProcessados);
        return new FundoInvestimentoProcessadoToPostResponseDTOMapper().map(fundosProcessadosRelatorio);
    }
}
