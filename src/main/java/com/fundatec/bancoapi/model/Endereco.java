package com.fundatec.bancoapi.model;

import com.fundatec.bancoapi.model.enums.Uf;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import com.fundatec.bancoapi.model.pessoas.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JoinColumn(name = "uf")
    private Uf uf;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "bairro")
    private String bairro;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Cliente cliente;
}
