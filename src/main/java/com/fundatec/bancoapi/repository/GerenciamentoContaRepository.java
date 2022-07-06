package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.contas.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface
GerenciamentoContaRepository extends JpaRepository<Conta, Integer>, GerenciamentoContaCustomRepository{


}
