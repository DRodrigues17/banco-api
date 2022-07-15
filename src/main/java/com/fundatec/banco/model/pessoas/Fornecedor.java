package com.fundatec.banco.model.pessoas;

import com.fundatec.banco.model.Endereco;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_fornecedor")
@Builder(builderMethodName = "fornecedorBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "RG", length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column
    private String telefone;

    @Column
    private Integer email;


}
