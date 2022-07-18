package com.fundatec.banco.model.contas;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.enums.StatusConta;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;


@Entity
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("conta_simples")
@Table(name = "conta_simples_tb")
public class ContaSimples extends Conta{

    public ContaSimples(Integer id, String cpfTitular, Banco banco, BigDecimal saldo, StatusConta status, String senhaAcesso, List<Movimentacao> movimentacoes) {
        super(id, cpfTitular, banco, saldo, status, senhaAcesso, movimentacoes);
    }

    public ContaSimples() {
    }
}
