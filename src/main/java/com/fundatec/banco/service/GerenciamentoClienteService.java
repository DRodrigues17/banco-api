package com.fundatec.banco.service;


import com.fundatec.banco.model.Endereco;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.repository.GerenciamentoClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GerenciamentoClienteService {

    @Autowired
    private final GerenciamentoClienteRepository repository;
    @Autowired
    private final EnderecoService enderecoService;


    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
    }


    public Iterable<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Cliente criarNovoCliente(Cliente cliente, Integer idEndereco) {
        Endereco endereco = enderecoService.findById(idEndereco);
        cliente.setEndereco(endereco);
        return repository.save(cliente);
    }
}
