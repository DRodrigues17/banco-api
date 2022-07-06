package com.fundatec.bancoapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.model.contas.ContaSimples;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Getter
@Table(name = "tb_movimentacoes")
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaSimples contaAcesso;
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaSimples contaOrigem;
    @ManyToOne(cascade = CascadeType.ALL)
    private ContaSimples contaDestino;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_movimentacao", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataMovimentacao;

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", contaAcesso=" + contaAcesso +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", valor=" + valor +
                ", dataMovimentacao=" + dataMovimentacao +
                '}';
    }
}

