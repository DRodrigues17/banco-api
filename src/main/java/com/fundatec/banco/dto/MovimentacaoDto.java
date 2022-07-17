package com.fundatec.banco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimentacaoDto {

    private Integer id;
    private BigDecimal valor;
    private LocalDateTime dataMovimentacao;
}
