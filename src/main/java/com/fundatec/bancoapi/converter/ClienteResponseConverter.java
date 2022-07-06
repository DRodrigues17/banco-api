package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.ClienteDto;
import com.fundatec.bancoapi.model.pessoas.Cliente;

public class ClienteResponseConverter  implements ClienteConverter<Cliente, ClienteDto> {


    @Override
    public ClienteDto convert(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .endereco(cliente.getEndereco())
                .build();
    }
}
