package com.fundatec.bancoapi.model.contas;

import java.math.BigDecimal;

public class ContaEspecial extends Conta{

    private BigDecimal limiteGastos = BigDecimal.valueOf(1500);

    @Override
    public void sacar(BigDecimal valor) throws RuntimeException {
        if (getSaldo().compareTo(valor) == 1) {
            super.sacar(valor);
            return;
        }
        if (getSaldo().compareTo(BigDecimal.valueOf(0.0)) == 0 && getLimiteGastos().compareTo(valor) >= 0){
            limiteGastos = limiteGastos.subtract(valor);
        }
        else if (getSaldo().compareTo(BigDecimal.valueOf(0.0)) == 0 && limiteGastos.compareTo(valor) == -1){
            throw new RuntimeException("impossivel sacar pois tal valor é maior que o limite");
        }
        else if (getLimiteGastos().compareTo(BigDecimal.valueOf(0.0)) == 0) {
            throw new RuntimeException("impossivel sacar pois seu limite foi atingido");
        }
    }

    public BigDecimal getLimiteGastos() {
        return limiteGastos;
    }
}
