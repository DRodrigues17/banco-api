package com.fundatec.banco.service;

import com.fundatec.banco.model.Banco;
import com.fundatec.banco.repository.GerenciamentoBancoRepository;
import com.fundatec.banco.repository.GerenciamentoClienteRepository;
import com.fundatec.banco.repository.GerenciamentoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GerenciamentoAdmService {

    private final GerenciamentoBancoRepository bancoRepository;
    private final GerenciamentoClienteRepository clienteRepository;
    private final GerenciamentoContaRepository contaRepository;

    @Autowired
    public GerenciamentoAdmService(GerenciamentoBancoRepository bancoRepository, GerenciamentoClienteRepository clienteRepository, GerenciamentoContaRepository contaRepository) {
        this.bancoRepository = bancoRepository;
        this.clienteRepository = clienteRepository;
        this.contaRepository = contaRepository;
    }

    public boolean verificarCredenciais(Integer idBanco, String senha) {
        Banco banco = bancoRepository.findById(idBanco).orElseThrow(() -> new RuntimeException(("Banco não encontrado")));
        return Objects.equals(banco.getSenha(), senha);
    }




}
