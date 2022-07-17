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
        conta.checarStatus();
        Movimentacao novaMovimentacao = gerarDadosParaMovimentacao(conta, valor);
        BigDecimal saldo = conta.getSaldo();
        conta.setSaldo(saldo.add(valor));
        addMovimentacao(novaMovimentacao);
    }

    public void sacar(Conta conta, BigDecimal valor) {
        conta.checarStatus();
        Movimentacao novaMovimentacao = gerarDadosParaMovimentacao(conta, valor);
        BigDecimal saldo = conta.getSaldo();
        conta.setSaldo(saldo.subtract(valor));
        addMovimentacao(novaMovimentacao);
    }

    private void addMovimentacao(Movimentacao novaMovimentacao) {
        service.saveMovimentacao(Movimentacao.builder()
                        .id(novaMovimentacao.getId())
                        .contaAcesso(novaMovimentacao.getContaAcesso())
                        .valor(novaMovimentacao.getValor())
                        .dataMovimentacao(novaMovimentacao.getDataMovimentacao())
                .build());
    }

    public Movimentacao transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        Movimentacao novaMovimentacao = gerarDadosParaMovimentacao(contaOrigem,valor);
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
        return service.saveMovimentacao(Movimentacao
                .builder()
                .id(novaMovimentacao.getId())
                .valor(novaMovimentacao.getValor())
                .contaAcesso(novaMovimentacao.getContaAcesso())
                .dataMovimentacao(novaMovimentacao.getDataMovimentacao())
                .build());
    }

    public Movimentacao gerarDadosParaMovimentacao(Conta conta, BigDecimal valor){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(valor);
        movimentacao.setContaAcesso(conta);
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        return movimentacao;
    }
}
