package com.fundatec.banco.service;

import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.repository.GerenciamentoBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciamentoBancoService {

    @Autowired
    private final GerenciamentoBancoRepository repository;

    public GerenciamentoBancoService(GerenciamentoBancoRepository repository) {
        this.repository = repository;
    }

    public Banco saveBanco(Banco banco) {
        return repository.save(banco);
    }

    public List<Banco> findAll() {
        return repository.findAll();
    }

    public Banco findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Banco não encontrado")));
    }

    public Conta getContaById(Banco banco, Integer contaId){
        List<Conta> contas = banco.getContas();

       Conta conta = contas.stream()
               .filter(conta1 -> contaId.equals(conta1.getId()))
               .findFirst()
               .orElseThrow(()->new RuntimeException("A conta em questão não se encontra neste banco."));
        return conta;
    }

}
