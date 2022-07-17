package com.fundatec.banco.controller;


import com.fundatec.banco.converter.ContaConverterImpl;
import com.fundatec.banco.dto.requestDtos.ContaRequestDto;
import com.fundatec.banco.dto.responseDtos.ContaResponseDto;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.service.GerenciamentoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final ContaConverterImpl converter;

    GerenciamentoContaController(GerenciamentoContaService contaService, ContaConverterImpl converter) {
        this.service = contaService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<ContaResponseDto>> findAll() {
        List<ContaResponseDto> contaResponseDtos = service.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contaResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaResponseDto> findBancoById(@PathVariable("id") Integer id) {
        Conta contaDto = service.findById(id);
        return ResponseEntity.ok(converter.convert(contaDto));
    }

    @PostMapping
    public ResponseEntity<ContaResponseDto> criarConta(@RequestBody ContaRequestDto contaRequestDto){
        Conta conta = service.criarNovaConta(converter.convert(contaRequestDto), contaRequestDto.getIdPessoaTitular(), contaRequestDto.getIdBanco());
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(conta));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ContaResponseDto> ModificarStatusConta(@PathVariable("id") Integer id){
        return ResponseEntity.ok(converter.convert(service.alterarStatus(id)));
    }

    @PatchMapping("/{idConta}/clientes/{idCliente}")
    public ResponseEntity<ContaResponseDto> VincularTiularDaConta(@PathVariable("idConta") Integer idConta,
                                                                  @PathVariable("idCliente") Integer idCliente){
        return ResponseEntity.ok(converter.convert(service.setTitular(idConta,idCliente)));
    }
}
