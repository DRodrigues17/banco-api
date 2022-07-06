package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GerenciamentoAdmRepository extends CrudRepository<Banco, Integer> {
}
