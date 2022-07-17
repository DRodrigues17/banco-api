package com.fundatec.banco.converter;

import com.fundatec.banco.dto.MovimentacaoDto;
import com.fundatec.banco.model.Movimentacao;

public class MovimentacaoResponseConverter implements MovimentacaoConverter<Movimentacao, MovimentacaoDto>{

    @Override
    public MovimentacaoDto convert(Movimentacao movimentacao) {
        return MovimentacaoDto.builder()
                .id(movimentacao.getId())
                .dataMovimentacao(movimentacao.getDataMovimentacao())
                .valor(movimentacao.getValor())
                .build();
    }
}
