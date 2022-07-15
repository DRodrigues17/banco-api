package com.fundatec.banco.model.contas;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaEspecial extends Conta {

    private BigDecimal limiteGastos = BigDecimal.valueOf(1500);

}
