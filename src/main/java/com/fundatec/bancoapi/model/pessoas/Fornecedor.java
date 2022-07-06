package com.fundatec.bancoapi.model.pessoas;

import com.fundatec.bancoapi.model.Endereco;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
public class Fornecedor {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "RG", length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Integer telefoneId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Integer emailId;


}
