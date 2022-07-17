package com.fundatec.banco.converter;

import com.fundatec.banco.dto.BancoDto;
import com.fundatec.banco.dto.ContaDto;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaResponseConverter implements ContaConverter<Conta, ContaDto> {

    @Override
    public ContaDto convert(Conta conta) {
        return ContaDto.builder().id(conta.getId())
                .cpfTitular(conta.getCpfTitular())
                .banco(BancoDto.builder()
                        .id(conta.getBanco().getId())
                        .nome(conta.getBanco().getNome())
                        .build()
                )
                .saldo(conta.getSaldo())
                .build();
    }
}
