package com.fundatec.banco.converter;

import com.fundatec.banco.dto.ClienteResponseDto;
import com.fundatec.banco.model.pessoas.Cliente;
import org.springframework.stereotype.Component;

@Component
public interface ClienteConverter <M extends Cliente, R extends ClienteResponseDto> {

    R convert(M cliente);

}
