package com.fundatec.banco.model.pessoas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Builder(builderMethodName = "clienteBuilder")
@Setter
@Table(name = "tb_cliente")
@JsonTypeName("cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends PessoaFisica {



    @Column(name = "profissão")
    private String profissao;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @MapsId("conta_id")
    @JsonBackReference(value = "conta_cliente")
    @JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
    private Conta conta;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @MapsId("banco_id")
    @JsonBackReference(value = "banco_cliente")
    @JoinColumn(name = "banco_id", referencedColumnName = "banco_id")
    private Banco banco;

}
