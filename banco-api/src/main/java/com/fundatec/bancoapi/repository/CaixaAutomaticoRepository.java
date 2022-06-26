package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.contas.Conta;
import org.hibernate.mapping.List;

import java.math.BigDecimal;

public interface CaixaAutomaticoRepository {

    public BigDecimal consultarSaldo(Conta conta);

    public List consultarExtrato(Conta conta);

    public BigDecimal depositar(Conta conta);

    public BigDecimal sacar(Conta conta);

    public BigDecimal realizarTransferencia(Conta conta);

}
