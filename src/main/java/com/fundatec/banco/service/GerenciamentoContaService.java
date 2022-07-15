package com.fundatec.banco.service;

import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.repository.GerenciamentoClienteRepository;
import com.fundatec.banco.repository.GerenciamentoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciamentoContaService {


    private final GerenciamentoContaRepository repository;
    private final GerenciamentoClienteRepository clienteRepository;

    @Autowired
    public GerenciamentoContaService(GerenciamentoContaRepository repository, GerenciamentoClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta criarNovaConta(Conta conta){
        return repository.save(conta);
    }

    public Conta ativarConta(Integer id) throws RuntimeException{
        Conta conta = findById(id);
        conta.setStatus(StatusConta.ATIVA);
        return repository.save(conta);
    }

    public Conta desativarConta(Integer id) throws RuntimeException {
        Conta conta = findById(id);
        conta.setStatus(StatusConta.INATIVA);
        return repository.save(conta);
    }

    public Conta findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
    }
    public Conta findByCpf(String cpfTitular){
        return repository.findByCpfTitular(cpfTitular).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
    }

    public Conta setTitular(Integer idConta, Integer idCliente){
       Conta conta = findById(idConta);
       if(conta.getCpfTitular()==null){
       Cliente cliente = clienteRepository.findById(idCliente).orElseThrow();
       conta.setCpfTitular(cliente.getCpf());
       return conta;
       }
       throw new RuntimeException("A conta em questão já possui um titular.");
    }
}
