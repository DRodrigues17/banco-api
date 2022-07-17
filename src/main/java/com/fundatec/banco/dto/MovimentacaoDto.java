package com.fundatec.banco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimentacaoDto {

    private Integer id;
    private BigDecimal valor;
    private LocalDateTime dataMovimentacao;
}
