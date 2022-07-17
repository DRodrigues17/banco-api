package com.fundatec.banco.service;

import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Endereco;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {


    @Autowired
    private final EnderecoRepository repository;



    public Endereco saveEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Endereço não encontrado")));
    }


}
