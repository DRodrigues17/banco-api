package com.fundatec.bancoapi.controller;


import com.fundatec.bancoapi.converter.BancoRequestConverter;
import com.fundatec.bancoapi.dto.BancoDto;
import com.fundatec.bancoapi.model.Banco;
import com.fundatec.bancoapi.service.GerenciamentoBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bancos")
public class GerenciamentoBancoController {

    @Autowired
    private final GerenciamentoBancoService service;
    private final BancoRequestConverter converter;


    public GerenciamentoBancoController(GerenciamentoBancoService service, BancoRequestConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> findBancoById(@PathVariable("id") Integer id) {
        Banco banco = service.findById(id);
        return ResponseEntity.ok(banco);
    }

    @PostMapping
    public ResponseEntity<Banco> criarNovoBanco(@RequestBody BancoDto bancoDto){
      Banco banco = converter.convert(bancoDto);
        return ResponseEntity.ok(service.saveBanco(banco));
    }
}
