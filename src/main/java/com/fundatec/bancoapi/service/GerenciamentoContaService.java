package com.fundatec.bancoapi.service;

import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.model.enums.StatusConta;
import com.fundatec.bancoapi.model.pessoas.Cliente;
import com.fundatec.bancoapi.repository.GerenciamentoClienteRepository;
import com.fundatec.bancoapi.repository.GerenciamentoContaRepository;
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
        return repository.findByCpfTitular(cpfTitular);
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
