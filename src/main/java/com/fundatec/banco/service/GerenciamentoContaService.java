package com.fundatec.banco.service;

import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.enums.StatusConta;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.repository.GerenciamentoClienteRepository;
import com.fundatec.banco.repository.GerenciamentoContaRepository;
import lombok.AllArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class GerenciamentoContaService {


    private final GerenciamentoContaRepository repository;
    private final GerenciamentoClienteRepository clienteRepository;
    private final GerenciamentoClienteService clienteService;

    private final GerenciamentoBancoService bancoService;


    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta criarNovaConta(Conta conta, Integer idCliente, Integer idBanco) {
       Banco banco = bancoService.findById(idBanco);
       Cliente cliente = clienteService.findById(idCliente);
       String cfpTitular = cliente.getCpf();
       conta.setBanco(banco);
       conta.setCpfTitular(cfpTitular);
       conta.setSaldo(BigDecimal.ZERO);
       conta.setStatus(StatusConta.ATIVA);

        return repository.save(conta);
    }
        public Conta ativarConta(Integer id) throws RuntimeException {
        Conta conta = findById(id);
        conta.setStatus(StatusConta.ATIVA);
        return repository.save(conta);
    }

    public Conta desativarConta(Integer id) throws RuntimeException {
        Conta conta = findById(id);
        conta.setStatus(StatusConta.INATIVA);
        return repository.save(conta);
    }

    public Conta criarConta(Conta conta) {
        return repository.save(conta);
    }

    public Conta findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException(("Cliente não encontrado")));
    }

    public Conta findByCpf(String cpfTitular) {
        return repository.findByCpfTitular(cpfTitular).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
    }

    public Conta setTitular(Integer idConta, Integer idCliente) {
        Conta conta = findById(idConta);
        if (conta.getCpfTitular() == null) {
            Cliente cliente = clienteRepository.findById(idCliente).orElseThrow();
            conta.setCpfTitular(cliente.getCpf());
            return conta;
        }
        throw new RuntimeException("A conta em questão já possui um titular.");
    }

    public Conta alterarStatus(Integer id) {
        Conta conta = findById(id);
        if (conta.getStatus() == StatusConta.INATIVA) {
            return ativarConta(id);
        }
        return desativarConta(id);
    }
}
