package com.fundatec.bancoapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BancoDto {

    private Integer id;
    private String nome;
    private String senha;

}
