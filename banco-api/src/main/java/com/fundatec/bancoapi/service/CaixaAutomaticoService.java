package com.fundatec.bancoapi.service;

import com.fundatec.bancoapi.model.contas.Conta;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class CaixaAutomaticoService {
    Scanner t = new Scanner(System.in);

    public BigDecimal consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

    public List consultarExtrato(Conta conta) {
        return conta.getMovimentacaoList();
    }

    public void depositar(Conta conta, BigDecimal valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, BigDecimal valor) {
        conta.sacar(valor);
    }

    public void transferir(Conta conta1, Conta conta2) {
        BigDecimal valor = t.nextBigDecimal();
        conta1.sacar(valor);
        conta2.depositar(valor);
    }
}
