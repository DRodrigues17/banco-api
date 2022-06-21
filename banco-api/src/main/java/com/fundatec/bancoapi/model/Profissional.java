package com.fundatec.bancoapi.model;

import javax.persistence.*;

public class Profissional extends PessoaFisica {

    @Column(name = "cargo")
    private String cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "especialidade")
    private String especialidade;
}
