package com.fundatec.bancoapi.service;


import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import com.fundatec.bancoapi.repository.GerenciamentoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenciamentoClienteService {

    @Autowired
    private final GerenciamentoClienteRepository repository;

    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
    }

    public GerenciamentoClienteService(GerenciamentoClienteRepository repository) {
        this.repository = repository;
    }
    public Iterable<Cliente> findAll(){ return repository.findAll();}

    public Cliente saveCliente(Cliente cliente){return repository.save(cliente);}

    public void deleteById(Integer id){
         repository.deleteById(id);
    }

}
