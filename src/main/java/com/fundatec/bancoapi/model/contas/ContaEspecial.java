package com.fundatec.bancoapi.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

//@Entity
//@Table(name = "conta_especial_tb")
public class ContaEspecial extends Conta{

    private BigDecimal limite;
}
