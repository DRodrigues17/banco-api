package com.fundatec.banco.controller;

import com.fundatec.banco.converter.ClienteResponseConverter;
import com.fundatec.banco.dto.ClienteResponseDto;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.service.GerenciamentoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/clientes")
@AllArgsConstructor
public class GerenciamentoClienteController {
    @Autowired
    private final GerenciamentoClienteService service;
    @Autowired
    private final ClienteResponseConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findClienteById(@PathVariable("id") Integer id){
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok(converter.convert(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> findAll(){
        Iterable<Cliente> cliente = service.findAll();
        List<ClienteResponseDto> clienteResponseDto = StreamSupport.stream(cliente.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(clienteResponseDto);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> newCliente(@RequestBody Cliente cliente) {
        Cliente clienteDto = service.saveCliente(cliente);
        return ResponseEntity.ok(converter.convert(clienteDto));
    }

    @DeleteMapping("{id}")
    public void deleteBancoById(@PathVariable("id") Integer id){service.deleteById(id);}
}
