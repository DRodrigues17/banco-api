package com.fundatec.bancoapi.service;

import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.repository.GerenciamentoBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Banco findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Banco não encontrado")));
    }

}
