package com.fundatec.banco.service;

import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.contas.Conta;
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
        conta.checarStatus();
        return conta.getSaldo();
    }

    public List<Movimentacao> consultarExtrato(Conta conta) {
        conta.checarStatus();
        return conta.getMovimentacoes();
    }

    public void depositar(Conta conta, BigDecimal valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, BigDecimal valor) {
        conta.checarStatus();
        conta.sacar(valor);
    }

    public Movimentacao transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
        LocalDateTime dataMovimentacao = LocalDateTime.now();
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(valor);
        movimentacao.setContaAcesso(contaOrigem);
        return service.saveMovimentacao(Movimentacao
                .builder()
                .valor(movimentacao.getValor())
                .contaAcesso(movimentacao.getContaAcesso())
                .build());
    }
}
