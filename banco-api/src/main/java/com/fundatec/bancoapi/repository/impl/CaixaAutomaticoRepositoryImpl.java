package com.fundatec.bancoapi.repository.impl;

import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.repository.CaixaAutomaticoRepository;
import org.hibernate.mapping.List;

import java.math.BigDecimal;
import java.util.Scanner;

public class CaixaAutomaticoRepositoryImpl implements CaixaAutomaticoRepository {

    Scanner t = new Scanner(System.in);

    @Override
    public BigDecimal consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

    @Override
    public List consultarExtrato(Conta conta) {
        return conta.getMovimentacaoList();
    }

    @Override
    public BigDecimal depositar(Conta conta) {
        BigDecimal valor = t.nextBigDecimal();
        BigDecimal saldo =  conta.getSaldo();
        if (valor.compareTo(BigDecimal.valueOf(0.0)) == 0|| valor.compareTo(new BigDecimal(0.0)) == -1 ){
            throw  new RuntimeException("valor inválido, logo não pode ser depositado");
        } else {
            saldo.add(valor);
            conta.setSaldo(saldo);
        }
        return null;
    }

    @Override
    public BigDecimal sacar(Conta conta) {
        BigDecimal valor = t.nextBigDecimal();
        BigDecimal saldo = conta.getSaldo();
        if (valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) == -1) {
            throw new RuntimeException("valor inválido, logo não pode ser sacado");
        } else if (valor.compareTo(saldo) == 1) {
            throw new RuntimeException("impossivel sacar um valor maior que seu saldo");
        } else {
            saldo.subtract(valor);
            conta.setSaldo(saldo);
        }
        return null;
    }

    // TODO
    @Override
    public BigDecimal realizarTransferencia(Conta conta) {
        return null;
    }
}
