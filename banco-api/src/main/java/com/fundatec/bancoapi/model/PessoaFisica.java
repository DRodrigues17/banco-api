package com.fundatec.bancoapi.model;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Table(name = "tb_pessoa")
@MappedSuperclass
public abstract class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "CPF", length = 11)
    private String cpf;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @Column(name = "data_cadastro")
    private Date data_cadastro;

    @Column (name = "status")
    private Boolean status;

}
