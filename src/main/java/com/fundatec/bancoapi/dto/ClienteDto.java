package com.fundatec.bancoapi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.bancoapi.model.Endereco;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {

    private Integer id;
    private String nome;
    private String cpf;
    private Endereco endereco;

}