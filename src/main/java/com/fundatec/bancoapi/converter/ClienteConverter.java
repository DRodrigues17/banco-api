package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.ClienteDto;
import com.fundatec.bancoapi.model.pessoas.Cliente;

public interface ClienteConverter <M extends Cliente, R extends ClienteDto> {

    R convert(M cliente);

}
