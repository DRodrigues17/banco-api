package com.fundatec.bancoapi.controller;


import com.fundatec.bancoapi.service.GerenciamentoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/contas")
public class GerenciamentoContaController {


    @Autowired
    private final GerenciamentoContaService service;

    GerenciamentoContaController(GerenciamentoContaService contaService) {

        this.service = contaService;

    }
}
