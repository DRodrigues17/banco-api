package com.fundatec.bancoapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.Movimentacao;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaDto {

    private Integer id;
    private String cpf;
    private Banco banco;
    private List<Movimentacao> movimentacaoList;
    private BigDecimal saldo;

}
