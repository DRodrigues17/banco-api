package com.fundatec.bancoapi.model.pessoas;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.Endereco;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;

}
