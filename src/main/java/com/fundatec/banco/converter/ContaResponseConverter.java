package com.fundatec.banco.converter;

import com.fundatec.banco.dto.BancoResponseDto;
import com.fundatec.banco.dto.ContaResponseDto;
import com.fundatec.banco.model.contas.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaResponseConverter implements ContaConverter<Conta, ContaResponseDto> {

    @Override
    public ContaResponseDto convert(Conta conta) {
        return ContaResponseDto.builder().id(conta.getId())
                .cpfTitular(conta.getCpfTitular())
                .banco(BancoResponseDto.builder()
                        .id(conta.getBanco().getId())
                        .nome(conta.getBanco().getNome())
                        .build()
                )
                .saldo(conta.getSaldo())
                .build();
    }
}
