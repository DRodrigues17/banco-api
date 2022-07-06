package com.fundatec.bancoapi.converter;

import com.fundatec.bancoapi.dto.ContaDto;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.contas.Conta;

public class ContaResponseConverter implements ContaConverter<Conta, ContaDto> {

    @Override
    public ContaDto convert(Conta conta) {
        return ContaDto.builder()
                .id(conta.getId())
                .cpf(conta.getCpfTitular())
                .saldo(conta.getSaldo())
                .banco(conta.getBanco() == null
                        ? null
                        : Banco.builder()
                                .id(conta.getBanco().getId())
                                .build())
                .build();
    }
}
