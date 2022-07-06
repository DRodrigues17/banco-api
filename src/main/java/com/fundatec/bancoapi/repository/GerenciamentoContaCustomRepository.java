package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.contas.Conta;
import org.springframework.stereotype.Repository;


@Repository
public interface GerenciamentoContaCustomRepository {

    Conta findByCpfTitular(String cpfTitular);
}
