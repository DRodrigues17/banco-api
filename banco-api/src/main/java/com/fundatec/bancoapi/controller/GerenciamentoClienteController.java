package com.fundatec.bancoapi.controller;


import com.fundatec.bancoapi.service.GerenciamentoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class GerenciamentoClienteController {

    @Autowired
    private final GerenciamentoClienteService service;

    public GerenciamentoClienteController(GerenciamentoClienteService clienteService) {

        this.service = clienteService;

    }

}
