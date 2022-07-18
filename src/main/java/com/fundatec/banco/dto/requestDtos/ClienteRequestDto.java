package com.fundatec.banco.dto.requestDtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.banco.dto.responseDtos.EnderecoResponseDto;
import com.fundatec.banco.model.Endereco;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteRequestDto {

    private String nome;
    private String cpf;
    private Integer idEndereco;
    private String sexo;
    private LocalDate dataNascimento;

}