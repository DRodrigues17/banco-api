package com.fundatec.bancoapi.model.pessoas;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
public class Profissional extends PessoaFisica {

    @Column(name = "cargo")
    private String cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "especialidade")
    private String especialidade;
}
