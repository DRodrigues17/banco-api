package com.fundatec.banco.model.contas;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.enums.TipoConta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Integer id;

    @Column(name = "cpf_titular", nullable = true, unique = true)
    private String cpfTitular;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference(value = "banco_conta")
    @JoinColumn(name = "banco_id", referencedColumnName = "banco_id")
    private Banco banco;
    @Column(name = "saldo")
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusConta status;

    @Column(name = "senha")
    private String senhaAcesso;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta")
    private TipoConta tipoConta;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contaAcesso")
    @JsonManagedReference
    private List<Movimentacao> movimentacoes;

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
