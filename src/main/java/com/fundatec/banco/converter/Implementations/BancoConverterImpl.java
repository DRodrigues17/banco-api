package com.fundatec.banco.converter.Implementations;

import com.fundatec.banco.converter.BancoConverter;
import com.fundatec.banco.dto.responseDtos.BancoResponseDto;
import com.fundatec.banco.model.Banco;
import org.springframework.stereotype.Component;

@Component
public class BancoConverterImpl implements BancoConverter<Banco, BancoResponseDto> {
    @Override
    public BancoResponseDto convert(Banco banco) {
        return BancoResponseDto.builder()
                .id(banco.getId())
                .nome(banco.getNome())
                .senha(banco.getSenha())
                .build();
    }
}