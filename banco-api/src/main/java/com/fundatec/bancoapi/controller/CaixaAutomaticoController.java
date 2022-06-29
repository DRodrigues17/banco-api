package com.fundatec.bancoapi.controller;


import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.service.CaixaAutomaticoService;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/caixa_automatico")
public class CaixaAutomaticoController {


    private final CaixaAutomaticoService service;

    public CaixaAutomaticoController(CaixaAutomaticoService service) {
        this.service = service;
    }


    @GetMapping("/saldo/{cpf}")
    public BigDecimal consultarSaldo(@PathVariable Conta conta){
        return service.consultarSaldo(conta);
    }

    @GetMapping("/extratos/{cpf}")
    public List consultarExtrato(@PathVariable Conta conta){
        return service.consultarExtrato(conta);
    }

    @PutMapping()
    public void depositar(@RequestParam Conta conta, BigDecimal valor){
        service.depositar(conta, valor);
    }

    @PutMapping()
    public void sacar(@RequestParam Conta conta, BigDecimal valor){
        service.sacar(conta, valor);
    }

    @PutMapping
    public void transferir(Conta conta1, Conta conta2){
        service.transferir(conta1, conta2);
    }
}
