package com.fundatec.bancoapi.service;

import com.fundatec.bancoapi.model.Movimentacao;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import com.fundatec.bancoapi.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovimentacaoService {

    @Autowired
    private final MovimentacaoRepository repository;

    public Movimentacao findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Movimentação não encontrada")));
    }

    public List<Movimentacao> findAllMovimentacoes(){ return repository.findAll();}

    public Movimentacao saveMovimentacao(Movimentacao movimentacao){return repository.save(movimentacao);}

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
