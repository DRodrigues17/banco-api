package com.fundatec.banco.controller;

import com.fundatec.banco.service.GerenciamentoAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/administrativo")
public class GerenciamentoAdmController {

    @Autowired
    private final GerenciamentoAdmService service;

    public GerenciamentoAdmController(GerenciamentoAdmService admService){
        this.service = admService;
    }








}