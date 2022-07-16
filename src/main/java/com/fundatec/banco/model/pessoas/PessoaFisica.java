package com.fundatec.banco.model.pessoas;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.banco.model.Endereco;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Getter
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;

}