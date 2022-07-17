package com.fundatec.banco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.banco.model.enums.Uf;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoDto {


    private Integer id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private Uf uf;
}
