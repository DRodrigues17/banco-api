package com.fundatec.banco.controller;

import com.fundatec.banco.converter.BancoConverterImpl;
import com.fundatec.banco.converter.EnderecoConverter;
import com.fundatec.banco.converter.EnderecoConverterImpl;
import com.fundatec.banco.dto.responseDtos.BancoResponseDto;
import com.fundatec.banco.dto.responseDtos.EnderecoResponseDto;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.Endereco;
import com.fundatec.banco.service.EnderecoService;
import com.fundatec.banco.service.GerenciamentoBancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    @Autowired
    private final EnderecoService service;
    @Autowired
    private final EnderecoConverterImpl converter;


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<EnderecoResponseDto>> findAll() {
        List<EnderecoResponseDto> endereco = service.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> findEnderecoById(@PathVariable("id") Integer id) {
        Endereco endereco = service.findById(id);
        return ResponseEntity.ok(converter.convert(endereco));
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> criarNovoEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(service.saveEndereco(endereco)));
    }
}
