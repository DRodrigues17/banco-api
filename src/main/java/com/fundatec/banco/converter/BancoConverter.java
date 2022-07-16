package com.fundatec.banco.converter;

import com.fundatec.banco.dto.BancoDto;
import com.fundatec.banco.model.Banco;
import org.springframework.stereotype.Component;

@Component
public interface BancoConverter  <M extends BancoDto, R extends Banco> {

    R convert(M cliente);
}
