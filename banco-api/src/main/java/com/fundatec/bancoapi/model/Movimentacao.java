package com.fundatec.bancoapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Table(name = "tb_movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "conta_origem", nullable = false)
    private Conta contaOrigem;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_movimentacao", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataMovimentacao;
}
