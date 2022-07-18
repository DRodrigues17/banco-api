package com.fundatec.banco.model.contas;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "conta_especial_tb")
@JsonTypeName("conta_especial")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaEspecial extends Conta {

    private BigDecimal limiteGastos = BigDecimal.valueOf(1500);

    @Override
    public void sacar(BigDecimal valor) throws RuntimeException {
        if (getSaldo().compareTo(valor) == 1){
            super.sacar(valor);
            return;
        }
        if(getSaldo().compareTo(BigDecimal.ZERO) == 0 && getLimiteGastos().compareTo(valor) >= 0){
            limiteGastos = limiteGastos.subtract(valor);
        }
        else if (getSaldo().compareTo(BigDecimal.ZERO) == 0 && getLimiteGastos().compareTo(valor) == -1) {
            throw new RuntimeException("impossivel sacar pois o valor é maior que o limite");
        }
        else if (getLimiteGastos().compareTo(BigDecimal.ZERO) == 0) {
            throw new RuntimeException("impossivel sacar pois seu limite foi atingido");
        }
    }

    public BigDecimal getLimiteGastos() {
        return limiteGastos;
    }
}
