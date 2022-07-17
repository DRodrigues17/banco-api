package com.fundatec.banco.converter;

import com.fundatec.banco.dto.EnderecoDto;
import com.fundatec.banco.model.Endereco;

public class EnderecoResponseConverter implements EnderecoConverter<Endereco, EnderecoDto> {

    @Override
    public EnderecoDto convert(Endereco endereco) {
        return EnderecoDto.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .build();
    }
}
