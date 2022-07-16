package com.fundatec.banco.converter;

import com.fundatec.banco.dto.BancoDto;
import com.fundatec.banco.model.Banco;
import org.springframework.stereotype.Component;

@Component
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
