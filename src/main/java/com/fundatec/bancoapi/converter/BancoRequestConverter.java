package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.BancoDto;
import com.fundatec.bancoapi.model.Banco;

public class BancoRequestConverter implements BancoConverter<BancoDto, Banco>{
    @Override
    public Banco convert(BancoDto banco) {
        return Banco.builder()
                .id(banco.getId())
                .nome(banco.getNome())
                .senha(banco.getSenha())
                .build();
    }
}
