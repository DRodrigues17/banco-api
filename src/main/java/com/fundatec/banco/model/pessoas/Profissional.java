package com.fundatec.banco.model.pessoas;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_profissional")
@Builder(builderMethodName = "profissionalBuilder")
@JsonTypeName("profissional")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "profissional_id")
@NoArgsConstructor
@AllArgsConstructor
public class Profissional extends PessoaFisica {

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "especialidade")
    private String especialidade;
}
