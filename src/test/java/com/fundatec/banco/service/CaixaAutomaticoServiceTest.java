package com.fundatec.banco.service;

import com.fundatec.banco.exception.NaoPermitidoException;
import com.fundatec.banco.model.Conta;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.enums.TipoConta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CaixaAutomaticoServiceTest {

    private Conta conta;
    private static Logger logger = Logger.getLogger(Conta.class.getName());

    private MovimentacaoService service;
    private CaixaAutomaticoService automaticoService = new CaixaAutomaticoService(service);

    @BeforeAll
    void init(){
        conta = new Conta(1, "12345678",null, BigDecimal.valueOf(0), StatusConta.ATIVA,
                "cloud", TipoConta.SIMPLES, null );

        automaticoService.addMovimentacao(automaticoService.gerarDadosParaMovimentacao(conta, BigDecimal.valueOf(60)));
        automaticoService.addMovimentacao(automaticoService.gerarDadosParaMovimentacao(conta, BigDecimal.valueOf(35)));
        automaticoService.addMovimentacao(automaticoService.gerarDadosParaMovimentacao(conta, BigDecimal.valueOf(70)));
        automaticoService.addMovimentacao(automaticoService.gerarDadosParaMovimentacao(conta, BigDecimal.valueOf(50)));
    }



    @Test
    void deveConsultarSaldo() {
        logger.info(conta.getSaldo().toString());
        assertEquals(conta.getSaldo(),automaticoService.consultarSaldo(conta));
    }

    @Test
    void deveDarErroAoConsultarSaldoPoisContaInativa() {
        conta.setStatus(StatusConta.INATIVA);
        assertThrows(NaoPermitidoException.class, () -> automaticoService.consultarSaldo(conta));
    }

    @Test
    void deveConsultarExtrato() {
        conta.setStatus(StatusConta.ATIVA);
        logger.info(conta.getMovimentacoes().toString());
        assertEquals(conta.getMovimentacoes(),automaticoService.consultarExtrato(conta));
    }

    @Test
    void deveDarErroAoConsultarExtratoPoisContaInativa() {
        conta.setStatus(StatusConta.INATIVA);
        assertThrows(NaoPermitidoException.class, () -> automaticoService.consultarExtrato(conta));
    }

}