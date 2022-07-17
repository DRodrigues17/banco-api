package com.fundatec.banco.controller;

import com.fundatec.banco.converter.ClienteResponseConverter;
import com.fundatec.banco.dto.ClienteDto;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.service.GerenciamentoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/clientes")
public class GerenciamentoClienteController {
    @Autowired
    private final GerenciamentoClienteService service;
    public GerenciamentoClienteController(GerenciamentoClienteService clienteService, ClienteResponseConverter converter) {this.service = clienteService;
        this.converter = converter;
    }
    @Autowired
    private final ClienteResponseConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findClienteById(@PathVariable Integer id){
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok(converter.convert(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll(){
        Iterable<Cliente> cliente = service.findAll();
        List<ClienteDto> clienteDto = StreamSupport.stream(cliente.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(clienteDto);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> newCliente(@RequestBody Cliente cliente) {
        Cliente clienteDto = service.saveCliente(cliente);
        return ResponseEntity.ok(converter.convert(clienteDto));
    }

    @PostMapping
    public ResponseEntity<Cliente> criarNovoBanco(@RequestBody Cliente cliente){
        return ResponseEntity.ok(service.saveCliente(cliente));
    }

    @DeleteMapping("{id}")
    public void deleteBancoById(@PathVariable Integer id){service.deleteById(id);}
}
