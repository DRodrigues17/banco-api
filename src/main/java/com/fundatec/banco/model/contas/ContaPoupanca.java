package com.fundatec.banco.model.contas;


import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta {

    private final double taxaJuros = 0.0015;

}
