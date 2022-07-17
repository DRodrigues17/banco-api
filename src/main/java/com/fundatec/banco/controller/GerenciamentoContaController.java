package com.fundatec.banco.controller;


import com.fundatec.banco.converter.ContaResponseConverter;
import com.fundatec.banco.dto.ContaDto;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.service.GerenciamentoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/contas")
public class GerenciamentoContaController {
    @Autowired
    private final GerenciamentoContaService service;
    @Autowired
    private final ContaResponseConverter converter;

    GerenciamentoContaController(GerenciamentoContaService contaService, ContaResponseConverter converter) {
        this.service = contaService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<ContaDto>> findAll() {
        List<ContaDto> contaDtos = service.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDto> findBancoById(@PathVariable("id") Integer id) {
        Conta contaDto = service.findById(id);
        return ResponseEntity.ok(converter.convert(contaDto));
    }



    @PatchMapping("/{id}")
    public ResponseEntity<ContaDto> ModificarStatusConta(@PathVariable("id") Integer id){
        return ResponseEntity.ok(converter.convert(service.alterarStatus(id)));
    }

    @PatchMapping("/{idConta}/clientes/{idCliente}")
    public ResponseEntity<ContaDto> VincularTiularDaConta(@PathVariable("idConta") Integer idConta,
    @PathVariable("idCliente") Integer idCliente){
        return ResponseEntity.ok(converter.convert(service.setTitular(idConta,idCliente)));
    }
}
