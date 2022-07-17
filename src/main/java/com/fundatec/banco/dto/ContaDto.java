package com.fundatec.banco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Movimentacao;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaDto {

    private Integer id;
    private String cpfTitular;
    private BancoDto banco;
    private List<Movimentacao> movimentacaoList;
    private BigDecimal saldo;


}
