package com.fundatec.banco.converter;

import com.fundatec.banco.dto.requestDtos.ClienteRequestDto;
import com.fundatec.banco.dto.responseDtos.ClienteResponseDto;
import com.fundatec.banco.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public interface ClienteConverter <M extends Cliente, R extends ClienteResponseDto, Re extends ClienteRequestDto> {

    R convert(M cliente);

    M convert(Re cliente);

}