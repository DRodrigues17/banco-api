package com.fundatec.banco.converter;

import com.fundatec.banco.dto.ClienteDto;
import com.fundatec.banco.model.pessoas.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteResponseConverter  implements ClienteConverter<Cliente, ClienteDto> {


    @Override
    public ClienteDto convert(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
