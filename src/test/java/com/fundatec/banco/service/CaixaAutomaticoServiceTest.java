package com.fundatec.banco.service;

import com.fundatec.banco.exception.NaoPermitidoException;
import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.contas.ContaSimples;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.enums.TipoOperacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class CaixaAutomaticoServiceTest {

    private ContaSimples conta;
    private static Logger logger = Logger.getLogger(Conta.class.getName());
    private MovimentacaoService service;
    private CaixaAutomaticoService automaticoService = new CaixaAutomaticoService(service);

    @BeforeEach
    void init(){
        conta = new ContaSimples(1111111111, null, null,
                BigDecimal.valueOf(1223), StatusConta.ATIVA, null, null );

        conta.adcionarMovimentacao(conta, TipoOperacao.DEPOSITO, BigDecimal.valueOf(50), LocalDateTime.now());
        conta.adcionarMovimentacao(conta, TipoOperacao.SAQUE, BigDecimal.valueOf(50), LocalDateTime.now());
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