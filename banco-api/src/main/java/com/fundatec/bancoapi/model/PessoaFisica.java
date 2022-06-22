package com.fundatec.bancoapi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate data_nascimento;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate data_cadastro;

    @Column (name = "status")
    private Boolean status;

}
