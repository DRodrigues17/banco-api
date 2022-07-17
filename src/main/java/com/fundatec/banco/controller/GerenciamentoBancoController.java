package com.fundatec.banco.controller;

import com.fundatec.banco.converter.BancoResponseConverter;
import com.fundatec.banco.dto.BancoResponseDto;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.service.GerenciamentoBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/bancos")
public class GerenciamentoBancoController {

    @Autowired
    private final GerenciamentoBancoService service;
    @Autowired
    private final BancoResponseConverter converter;

    public GerenciamentoBancoController(GerenciamentoBancoService service, BancoResponseConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Banco>> findAll() {
        Iterable<Banco> bancoDto = service.findAll();
        List<Banco> banco = StreamSupport.stream(bancoDto.spliterator(), false).toList();
        return ResponseEntity.ok(banco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoResponseDto> findBancoById(@PathVariable("id") Integer id) {
        Banco banco = service.findById(id);
        return ResponseEntity.ok(converter.convert(banco));
    }

    @PostMapping
    public ResponseEntity<Banco> criarNovoBanco(@RequestBody Banco banco) {
        return ResponseEntity.ok(service.saveBanco(banco));
    }
}
