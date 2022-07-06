package com.fundatec.bancoapi.model.contas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    private Conta conta;

    @BeforeEach
    void init(){
        conta = new Conta() {
            @Override
            public void depositar(BigDecimal valor) {
                super.depositar(valor);
            }

            @Override
            public void sacar(BigDecimal valor) {
                super.sacar(valor);
            }
        };
    };

    @Test
    void deveDepositarCorretamente() {
        conta.depositar(BigDecimal.valueOf(16));
        assertEquals(BigDecimal.valueOf(16), conta.getSaldo());
    }

    @Test
    void deveSacarCorretamente() {
        conta.depositar(BigDecimal.valueOf(20));
        conta.sacar(BigDecimal.valueOf(16));
        assertEquals(BigDecimal.valueOf(4), conta.getSaldo());
    }

    @Test
    void deveDarErroAoDepositarNullo(){
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(null));
    }

    @Test
    void deveDarErroAoDepositarZero(){
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(BigDecimal.ZERO));
    }

    @Test
    void deveDarErroAoDepositarNegativo(){
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(BigDecimal.valueOf(-1)));
    }

    @Test
    void deveDarErroAoSacarValorMaiorQueSaldo(){
        conta.depositar(BigDecimal.valueOf(20));
        assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(777)));
    }

    @Test
    void deveDarErroAoSacarNullo(){
        conta.depositar(BigDecimal.valueOf(20));
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(null));
    }

    @Test
    void deveDarErroAoSacarZero(){
        conta.depositar(BigDecimal.valueOf(20));
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(BigDecimal.ZERO));
    }

    @Test
    void deveDarErroAoSacarNegativo(){
        conta.depositar(BigDecimal.valueOf(20));
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(BigDecimal.valueOf(-1)));
    }

    @Test
    void deveDarErroAoSacarPoisSaldoNulo (){
        assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(1)));
    }
}