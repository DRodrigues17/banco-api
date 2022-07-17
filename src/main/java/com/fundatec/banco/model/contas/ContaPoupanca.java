package com.fundatec.banco.model.contas;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonTypeName("conta_poupanca")
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta {

    private final double taxaJuros = 0.0015;

}
