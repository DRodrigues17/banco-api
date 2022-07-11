package com.fundatec.bancoapi.model.contas;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
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

    private List<String> movimentacaoList;



    public void depositar(BigDecimal valor) {
        if ( valor== null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0|| valor.compareTo(BigDecimal.valueOf(0.0)) < 0 ){
            throw new IllegalArgumentException("valor inválido, logo não pode ser depositado");
        } else {
            saldo = saldo.add(valor);
            adcionarMovimentacao("depósito de $" + valor + " efetuado com sucesso às " + LocalDateTime.now());
        }
    }

    public void sacar(BigDecimal valor) throws RuntimeException {
        if ( valor== null || valor.compareTo(BigDecimal.valueOf(0.0)) == 0 || valor.compareTo(BigDecimal.valueOf(0.0)) < 0 ) {
            throw new IllegalArgumentException("valor inválido, logo não pode ser sacado");
        } else if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException("impossivel sacar um valor maior que seu saldo");
        } else if (getSaldo().compareTo(BigDecimal.valueOf(0.0)) == 0) {
            throw new RuntimeException("impossivel sacar pois seu saldo está zerado");
        } else {
            saldo = saldo.subtract(valor);
            adcionarMovimentacao("saque de $" + valor + " efetuado com sucesso às " + LocalDateTime.now());
        }
    }

    public void adcionarMovimentacao(String message){
        movimentacaoList.add(message);
    }

    public List<String> getMovimentacaoList() {
        return movimentacaoList.stream().toList();
    }

    public Integer getId() {
        return id;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
