package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GerenciamentoBancoRepository extends JpaRepository<Banco, Integer> {




}
