package com.fundatec.banco.converter;

import com.fundatec.banco.dto.requestDtos.ContaRequestDto;
import com.fundatec.banco.dto.responseDtos.ContaResponseDto;
import com.fundatec.banco.model.Conta;
import org.springframework.stereotype.Component;

@Component
public interface ContaConverter <M extends Conta, R extends ContaResponseDto, Re extends ContaRequestDto>{


    R convert(M conta);

    M convert(Re conta);
}