package com.fundatec.bancoapi.model;

import javax.persistence.*;

public class Cliente extends PessoaFisica {

    @Column(name = "profissão")
    private String profissao;


}
