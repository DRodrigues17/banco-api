package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.ContaDto;
import com.fundatec.bancoapi.model.contas.Conta;

public interface ContaConverter <M extends Conta, R extends ContaDto>{


    R convert(M conta);
}
