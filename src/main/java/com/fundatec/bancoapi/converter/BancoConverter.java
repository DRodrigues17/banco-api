package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.BancoDto;
import com.fundatec.bancoapi.model.Banco;

public interface BancoConverter  <M extends BancoDto, R extends Banco> {

    R convert(M cliente);
}
