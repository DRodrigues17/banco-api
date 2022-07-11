package com.fundatec.bancoapi.model;

import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Table(name = "tb_banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    private String senhaGerencial;

    private List<Cliente> clientes;

    private List<Conta> contas;

}
