package com.fundatec.banco.model.pessoas;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@Table(name = "tb_profissional")
@Builder(builderMethodName = "profissionalBuilder")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Profissional extends PessoaFisica {

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "especialidade")
    private String especialidade;
}
