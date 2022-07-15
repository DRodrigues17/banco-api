package com.fundatec.banco.model;

import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.pessoas.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banco_id")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private List<Conta> contas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private List<Cliente> clientes;

    @Column(name = "nome")
    private String nome;

    private String senha;
}
