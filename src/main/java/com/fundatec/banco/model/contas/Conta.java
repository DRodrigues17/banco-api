package com.fundatec.banco.model.contas;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.enums.TipoOperacao;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContaSimples.class, name = "conta_simples"),
        @JsonSubTypes.Type(value = ContaEspecial.class, name = "conta_especial"),
        @JsonSubTypes.Type(value = ContaPoupanca.class, name = "conta_poupanca")
})
public abstract class Conta {

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
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(name = "status")
    private StatusConta status;

    @Column(name = "senha")
    private String senhaAcesso;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contaAcesso")
    @JsonManagedReference
    private List<Movimentacao> movimentacoes;

    public boolean checarStatus(StatusConta status){
        if (StatusConta.INATIVA == getStatus()) {
            return false;
        }
        return true;
    }

    public void depositar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) < 0) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser depositado");
        } else {
            saldo = saldo.add(valor);
        }
    }

    public void sacar(BigDecimal valor) throws RuntimeException {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) < 0) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser sacado");
        } else if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException("impossivel sacar um valor maior que seu saldo");
        } else if (getSaldo().compareTo(BigDecimal.ZERO) == 0) {
            throw new RuntimeException("impossivel sacar pois seu saldo está zerado");
        } else {
            saldo = saldo.subtract(valor);
        }
    }

    public void adcionarMovimentacao(Conta conta, TipoOperacao tipoOperacao, BigDecimal valor, LocalDateTime timestamp) {
        Movimentacao movimentacao = new Movimentacao(conta, tipoOperacao, valor, timestamp);
        movimentacoes.add(movimentacao);
    }
}
