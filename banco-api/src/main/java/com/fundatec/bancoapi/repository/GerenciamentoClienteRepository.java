package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.pessoas.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface GerenciamentoClienteRepository extends CrudRepository<Cliente, Integer> {
}
