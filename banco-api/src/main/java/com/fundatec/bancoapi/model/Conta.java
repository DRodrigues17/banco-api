package com.fundatec.bancoapi.model;

import lombok.Getter;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@MappedSuperclass
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf_titular", nullable = false)
    private String cpf_titular;

    @Column(name = "saldo")
    private BigDecimal saldo;

    private String senha_acesso;

    private List movimentacao_list;

}
