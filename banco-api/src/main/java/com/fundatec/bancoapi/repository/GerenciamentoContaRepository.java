package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.Conta;
import org.springframework.data.repository.CrudRepository;

public interface
GerenciamentoContaRepository extends CrudRepository<Conta, Integer> {
}
