package com.fundatec.banco.converter;

import com.fundatec.banco.dto.ClienteDto;
import com.fundatec.banco.model.pessoas.Cliente;
import org.springframework.stereotype.Component;

@Component
public interface ClienteConverter <M extends Cliente, R extends ClienteDto> {

    R convert(M cliente);

}
