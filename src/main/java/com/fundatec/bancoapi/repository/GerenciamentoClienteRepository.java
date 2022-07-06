package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.pessoas.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GerenciamentoClienteRepository extends JpaRepository<Cliente, Integer> {
}
