package com.fundatec.banco.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.banco.model.Endereco;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {

    private Integer id;
    private String nome;
    private String cpf;
    private Endereco endereco;


}
