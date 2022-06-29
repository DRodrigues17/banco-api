package com.fundatec.bancoapi.model.contas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaEspecialTest {

    ContaEspecial conta = new ContaEspecial();



    @Test
    void deveSacarCorretamente() {
        conta.depositar(BigDecimal.valueOf(50));
        conta.sacar(BigDecimal.valueOf(15));
        assertEquals(BigDecimal.valueOf(35), conta.getSaldo());
    }

    @Test
    void deveSacarCorretamenteSaldoNulo() {
        conta.sacar(BigDecimal.valueOf(15));
        assertEquals(BigDecimal.valueOf(1485), conta.getLimiteGastos());
    }

    @Test
    void deveDarErroAoSacarValorMaiorQueLimite(){
        conta.sacar(BigDecimal.valueOf(1000));
        System.out.println(conta.getLimiteGastos());
         assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(777)));
    }

    @Test
    void deveDarErroAoSacarPoisLimiteAtingido (){
        conta.sacar(BigDecimal.valueOf(1500));
        System.out.println(conta.getLimiteGastos());
        assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(1)));
    }
}