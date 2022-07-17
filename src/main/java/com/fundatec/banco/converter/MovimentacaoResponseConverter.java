package com.fundatec.banco.converter;

import com.fundatec.banco.dto.MovimentacaoResponseDto;
import com.fundatec.banco.model.Movimentacao;
import org.springframework.stereotype.Component;


@Component
public class MovimentacaoResponseConverter implements MovimentacaoConverter<Movimentacao, MovimentacaoResponseDto>{

    @Override
    public MovimentacaoResponseDto convert(Movimentacao movimentacao) {
        return MovimentacaoResponseDto.builder()
                .id(movimentacao.getId())
                .dataMovimentacao(movimentacao.getDataMovimentacao())
                .valor(movimentacao.getValor())
                .build();
    }
}
