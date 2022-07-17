package com.fundatec.banco.converter;

import com.fundatec.banco.dto.requestDtos.ContaRequestDto;
import com.fundatec.banco.dto.responseDtos.BancoResponseDto;
import com.fundatec.banco.dto.responseDtos.ContaResponseDto;
import com.fundatec.banco.model.contas.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaConverterImpl implements ContaConverter<Conta, ContaResponseDto, ContaRequestDto> {

    @Override
    public ContaResponseDto convert(Conta conta) {
        return ContaResponseDto.builder().id(conta.getId())
                .cpfTitular(conta.getCpfTitular())
                .banco(conta.getBanco() == null
                        ? null
                        :
                        BancoResponseDto.builder()
                        .id(conta.getBanco().getId())
                        .nome(conta.getBanco().getNome())
                        .build()
                )
                .saldo(conta.getSaldo())
                .build();
    }

    @Override
    public Conta convert(ContaRequestDto conta) {
        return Conta.builder()
                .tipoConta(conta.getTipoConta())
                .tipoConta(conta.getTipoConta())
                .senhaAcesso(conta.getSenhaAcesso())
                .build();
    }
}
