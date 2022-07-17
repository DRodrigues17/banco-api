package com.fundatec.banco.converter;

import com.fundatec.banco.dto.ClienteResponseDto;
import com.fundatec.banco.model.pessoas.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteResponseConverter  implements ClienteConverter<Cliente, ClienteResponseDto> {


    @Override
    public ClienteResponseDto convert(Cliente cliente) {
        return ClienteResponseDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
