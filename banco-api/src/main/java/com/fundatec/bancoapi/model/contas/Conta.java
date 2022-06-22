package com.fundatec.bancoapi.model.contas;

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
    private String cpfTitular;

    @Column(name = "saldo")
    private BigDecimal saldo;

    private String senhaAcesso;

    private List movimentacaoList;

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
