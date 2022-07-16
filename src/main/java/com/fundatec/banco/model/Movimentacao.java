package com.fundatec.banco.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.banco.model.contas.Conta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@Table(name = "tb_movimentacoes")
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta contaAcesso;
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
                ", valor=" + valor +
                ", dataMovimentacao=" + dataMovimentacao +
                '}';
    }
}

