package com.fundatec.bancoapi.model;

import com.fundatec.bancoapi.model.enums.Uf;

import javax.persistence.*;

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JoinColumn(name = "uf")
    private Uf uf;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "bairro")
    private String bairro;
}
