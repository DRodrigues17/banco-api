package com.fundatec.banco.service;

import com.fundatec.banco.exception.NaoPermitidoException;
import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CaixaAutomaticoService {

    private final MovimentacaoService service;

    public BigDecimal consultarSaldo(Conta conta) {
        if(!conta.checarStatus(conta.getStatus())) {
            throw new NaoPermitidoException("sua conta está inativa");
        }
        return conta.getSaldo();
    }

    public List<Movimentacao> consultarExtrato(Conta conta) {
        if(!conta.checarStatus(conta.getStatus())) {
            throw new NaoPermitidoException("sua conta está inativa");
        }
        return conta.getMovimentacoes();
    }

    public void depositar(Conta conta, BigDecimal valor) {
        if(!conta.checarStatus(conta.getStatus())) {
            throw new NaoPermitidoException("sua conta está inativa");
        }
        conta.depositar(valor);
        conta.adcionarMovimentacao(conta, TipoOperacao.DEPOSITO, valor, LocalDateTime.now());
    }

    public void sacar(Conta conta, BigDecimal valor) {
        if(!conta.checarStatus(conta.getStatus())) {
            throw new NaoPermitidoException("sua conta está inativa");
        }
        conta.sacar(valor);
        conta.adcionarMovimentacao(conta, TipoOperacao.SAQUE, valor, LocalDateTime.now());
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        contaOrigem.sacar(valor);
        contaOrigem.adcionarMovimentacao(contaOrigem, TipoOperacao.SAQUE, valor, LocalDateTime.now());
        contaDestino.depositar(valor);
        contaDestino.adcionarMovimentacao(contaDestino, TipoOperacao.DEPOSITO, valor, LocalDateTime.now());
    }
}
