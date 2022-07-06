package com.fundatec.bancoapi.model.contas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaPoupancaTest {

    Conta conta = new ContaPoupanca();

    @Test
    void deveDepositarCorretamente() {
        conta.depositar(BigDecimal.valueOf(77));
        assertEquals(BigDecimal.valueOf(76.88).doubleValue(), conta.getSaldo().doubleValue(), 0.01);
    }

    @Test
    void deveSacarCorretamente() {
        conta.depositar(BigDecimal.valueOf(20));
        conta.sacar(BigDecimal.valueOf(16));
        assertEquals(BigDecimal.valueOf(3.97).doubleValue() , conta.getSaldo().doubleValue(), 0.1);
    }

}