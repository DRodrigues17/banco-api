package com.fundatec.bancoapi.model.contas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.Movimentacao;
import com.fundatec.bancoapi.model.enums.StatusConta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "cpf_titular", nullable = true, unique = true)
    private String cpfTitular;

    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "banco_id")
    private Banco banco;
    @Column(name = "saldo")
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(name = "status")
    private StatusConta status;

    @Column(name = "senha")
    private String senhaAcesso;

    @OneToMany
    @JoinColumn(name = "conta_id")
    private List<Movimentacao> movimentacaoList;

    public void checarStatus() throws RuntimeException {
        if (StatusConta.INATIVA == getStatus()) {
            throw new RuntimeException("A conta em questão está desativada, favor contatar seu gerente");
        }
    }

    public void depositar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) == -1) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser depositado");
        } else {
            saldo = saldo.add(valor);
            //adcionarMovimentacao("depósito de $" + valor + " efetuado com sucesso às " + LocalDateTime.now());
        }
    }

    public void sacar(BigDecimal valor) throws RuntimeException {
        if (valor == null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) < 0) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser sacado");
        } else if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException("impossivel sacar um valor maior que seu saldo");
        } else if (getSaldo().compareTo(BigDecimal.valueOf(0.0)) == 0) {
            throw new RuntimeException("impossivel sacar pois seu saldo está zerado");
        } else {
            saldo = saldo.subtract(valor);
            //adcionarMovimentacao("saque de $" + valor + " efetuado com sucesso às " + LocalDateTime.now());
        }
    }


}
