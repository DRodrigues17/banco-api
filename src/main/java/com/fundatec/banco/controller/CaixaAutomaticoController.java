package com.fundatec.banco.controller;


import com.fundatec.banco.model.Movimentacao;
import com.fundatec.banco.model.Conta;
import com.fundatec.banco.service.CaixaAutomaticoService;
import com.fundatec.banco.service.GerenciamentoClienteService;
import com.fundatec.banco.service.GerenciamentoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/caixa_automatico")
public class CaixaAutomaticoController {


    private final CaixaAutomaticoService service;
    private final GerenciamentoContaService contaService;
    private final GerenciamentoClienteService clienteService;


    @Autowired
    public CaixaAutomaticoController(CaixaAutomaticoService service, GerenciamentoContaService contaService, GerenciamentoClienteService clienteService) {
        this.service = service;
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    @GetMapping("/saldo/{cpf}")
    @ResponseStatus(HttpStatus.FOUND)
    public BigDecimal consultarSaldo(@PathVariable Integer idConta) {
        Conta conta = contaService.findById(idConta);
        return service.consultarSaldo(conta);
    }

    @GetMapping("/extratos/{cpf}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Movimentacao> consultarExtrato(@PathVariable String cpfTitular) {
        Conta conta = contaService.findByCpf(cpfTitular);
        return service.consultarExtrato(conta);
    }

    @PutMapping("/depositar/{idConta}/{valor}")
    @ResponseStatus(HttpStatus.OK)
    public void depositar(@PathVariable Integer idConta, @PathVariable BigDecimal valor) {
        Conta conta = contaService.findById(idConta);
        service.depositar(conta, valor);
    }

    @PutMapping("/sacar/{idConta}/{valor}")
    @ResponseStatus(HttpStatus.OK)
    public void sacar(@PathVariable Integer idConta, @PathVariable BigDecimal valor) {
        Conta conta = contaService.findById(idConta);
        service.sacar(conta, valor);
    }

    @PutMapping("/{idConta1}/{idConta2}/{valor}")
    @ResponseStatus(HttpStatus.OK)
    public void transferir(@PathVariable Integer idConta1, @PathVariable Integer idConta2, @PathVariable BigDecimal valor) {
        Conta conta1 = contaService.findById(idConta1);
        Conta conta2 = contaService.findById(idConta2);
        service.transferir(conta1, conta2, valor);
    }
}