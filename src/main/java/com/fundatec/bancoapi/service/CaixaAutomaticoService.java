package com.fundatec.bancoapi.service;

import com.fundatec.bancoapi.model.Movimentacao;
import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class CaixaAutomaticoService {

    private final MovimentacaoService service;

    public BigDecimal consultarSaldo(Conta conta) {
        conta.checarStatus();
        return conta.getSaldo();
    }

    public List<Movimentacao> consultarExtrato(Conta conta) {
        conta.checarStatus();
        return conta.getMovimentacaoList();
    }

    public void depositar(Conta conta, BigDecimal valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, BigDecimal valor) {
        conta.checarStatus();
        conta.sacar(valor);
    }

    public Movimentacao transferir(Movimentacao movimentacao) {
        Conta contaOrigem =movimentacao.getContaOrigem();
        contaOrigem.checarStatus();
        BigDecimal valor = movimentacao.getValor();
        contaOrigem.sacar(valor);
        Conta contaDestino = movimentacao.getContaDestino();
        contaDestino.depositar(valor);
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        service.saveMovimentacao(movimentacao);
        return movimentacao;
    }
}
