package com.fundatec.bancoapi.model;

import javax.persistence.*;
import java.util.Date;

public class Fornecedor {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "RG", length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nome_fantasia;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Column(name = "data_cadastro")
    private Date data_cadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Integer telefone_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Integer email_id;


}
