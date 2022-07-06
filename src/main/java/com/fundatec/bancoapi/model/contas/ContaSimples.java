package com.fundatec.bancoapi.model.contas;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "conta_simples_tb")
public class ContaSimples extends Conta{

}
