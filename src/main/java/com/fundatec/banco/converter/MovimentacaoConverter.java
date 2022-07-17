package com.fundatec.banco.converter;

import com.fundatec.banco.dto.MovimentacaoDto;
import com.fundatec.banco.model.Movimentacao;
import org.springframework.stereotype.Component;

@Component
public interface MovimentacaoConverter <M extends Movimentacao, R extends MovimentacaoDto>{

    R convert(M movimentacao);

}
