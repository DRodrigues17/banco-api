package com.fundatec.banco.model;

import com.fundatec.banco.model.enums.Uf;
import com.fundatec.banco.model.pessoas.PessoaFisica;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer Id;

    @JoinColumn(name = "uf")
    private Uf uf;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "bairro")
    private String bairro;

    @OneToOne
    @MapsId("pessoa_id")
    @JoinColumn(name = "pessoa_id",referencedColumnName = "pessoa_id")
    private PessoaFisica cliente;
}
