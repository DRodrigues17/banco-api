package com.fundatec.banco.converter;

import com.fundatec.banco.dto.BancoResponseDto;
import com.fundatec.banco.model.Banco;
import org.springframework.stereotype.Component;

@Component
public class BancoResponseConverter implements BancoConverter<Banco, BancoResponseDto>{
      @Override
    public BancoResponseDto convert(Banco banco) {
        return BancoResponseDto.builder()
                .id(banco.getId())
                .nome(banco.getNome())
                .senha(banco.getSenha())
                .build();
    }
}
