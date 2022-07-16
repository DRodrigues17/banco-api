package com.fundatec.banco.model.pessoas;

import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(builderMethodName = "clienteBuilder")
@Setter
@Table(name = "tb_cliente")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends PessoaFisica {

    @Column(name = "profissão")
    private String profissao;

    @ManyToOne
    @MapsId("conta_id")
    @JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
    private Conta conta;

//    @Column(name = "conta_id")
//    private Integer contaId;
//
//    public void setContaId(Conta conta) {
//        Integer contaId = conta.getId();
//        this.contaId = contaId;
//    }

    @ManyToOne
    @MapsId("banco_id")
    @JoinColumn(name = "banco_id", referencedColumnName = "banco_id")
    private Banco banco;
}
