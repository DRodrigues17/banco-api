package com.fundatec.banco.model.contas;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "conta_simples_tb")
public class ContaSimples extends Conta{



}
