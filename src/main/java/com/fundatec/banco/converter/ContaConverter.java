package com.fundatec.banco.converter;

import com.fundatec.banco.dto.ContaDto;
import com.fundatec.banco.model.contas.Conta;
import org.springframework.stereotype.Component;

@Component
public interface ContaConverter <M extends Conta, R extends ContaDto>{


    R convert(M conta);
}
