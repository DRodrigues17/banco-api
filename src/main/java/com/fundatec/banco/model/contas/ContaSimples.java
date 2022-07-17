package com.fundatec.banco.model.contas;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("conta_simples")
@Table(name = "conta_simples_tb")
public class ContaSimples extends Conta{



}
