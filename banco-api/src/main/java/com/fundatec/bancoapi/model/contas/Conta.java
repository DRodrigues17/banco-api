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
    private BigDecimal saldo = BigDecimal.ZERO;

    private String senhaAcesso;

    private List movimentacaoList;




    public void depositar(BigDecimal valor) {
        if ( valor== null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0|| valor.compareTo(BigDecimal.valueOf(0.0)) == -1 ){
            throw new IllegalArgumentException("valor inválido, logo não pode ser depositado");
        } else {
            saldo = saldo.add(valor);
        }
    }

    public void sacar(BigDecimal valor) throws RuntimeException {
        if ( valor== null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) == -1 ) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser sacado");
        } else if (valor.compareTo(saldo) == 1) {
            throw new RuntimeException("impossivel sacar um valor maior que seu saldo");
        } else if (getSaldo().compareTo(BigDecimal.valueOf(0.0)) == 0) {
            throw new RuntimeException("impossivel sacar pois seu saldo está zerado");
        } else {
            saldo = saldo.subtract(valor);
        }
    }

}
