package com.fundatec.banco.converter;

import com.fundatec.banco.dto.EnderecoDto;
import com.fundatec.banco.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public interface EnderecoConverter<M extends Endereco, R extends EnderecoDto>{

    R convert(M endereco);
}
