package com.fundatec.banco.model.contas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ContaEspecialTest {

    ContaEspecial conta = new ContaEspecial();

    private static Logger logger = Logger.getLogger(ContaEspecial.class.getName());

    @Test
    void deveSacarCorretamente() {
        logger.info(conta.getSaldo().toString());
        logger.info(conta.getLimiteGastos().toString());
        conta.depositar(BigDecimal.valueOf(50));
        logger.info(conta.getSaldo().toString());
        logger.info(conta.getLimiteGastos().toString());
        conta.sacar(BigDecimal.valueOf(15));
        logger.info(conta.getSaldo().toString());
        logger.info(conta.getLimiteGastos().toString());
        assertEquals(BigDecimal.valueOf(35), conta.getSaldo());
    }

    @Test
    void deveSacarCorretamenteSaldoNulo(){
        logger.info(conta.getLimiteGastos().toString());
        conta.sacar(BigDecimal.valueOf(15));
        logger.info(conta.getSaldo().toString());
        logger.info(conta.getLimiteGastos().toString());
        assertEquals(BigDecimal.valueOf(1485), conta.getLimiteGastos());
    }

    @Test
    void deveDarErroAoSacarValorMaiorQueLimite(){;
        logger.info(conta.getLimiteGastos().toString());
        conta.sacar(BigDecimal.valueOf(1000));
        logger.info(conta.getLimiteGastos().toString());
        assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(777)));
    }

    @Test
    void deveDarErroAoSacarPoisLimiteAtingido(){
        logger.info(conta.getLimiteGastos().toString());
        conta.sacar(BigDecimal.valueOf(1500));
        logger.info(conta.getLimiteGastos().toString());
        assertThrows(RuntimeException.class, () -> conta.sacar(BigDecimal.valueOf(1)));
    }
}