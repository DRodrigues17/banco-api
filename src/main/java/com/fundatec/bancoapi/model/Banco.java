package com.fundatec.bancoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.model.contas.ContaSimples;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Table(name = "tb_banco")
@NoArgsConstructor
@AllArgsConstructor
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "banco", targetEntity = ContaSimples.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContaSimples> contas;

    @Column(name = "nome")
    private String nome;

    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "banco", targetEntity = Cliente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    private String senha;



    public boolean isTitular(){
        return true;
    }
}
