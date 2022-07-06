package com.fundatec.bancoapi.model.pessoas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.contas.ContaSimples;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Component
@Table(name = "tb_cliente")

public class Cliente extends PessoaFisica {

    @Column(name = "profissão")
    private String profissao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ContaSimples conta;

    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "banco_id")
    private Banco banco;
}
