package com.fundatec.bancoapi.repository;

import com.fundatec.bancoapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
