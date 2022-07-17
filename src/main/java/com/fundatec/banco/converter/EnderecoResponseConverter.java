package com.fundatec.banco.converter;

import com.fundatec.banco.dto.EnderecoResponseDto;
import com.fundatec.banco.model.Endereco;

public class EnderecoResponseConverter implements EnderecoConverter<Endereco, EnderecoResponseDto> {

    @Override
    public EnderecoResponseDto convert(Endereco endereco) {
        return EnderecoResponseDto.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .build();
    }
}
