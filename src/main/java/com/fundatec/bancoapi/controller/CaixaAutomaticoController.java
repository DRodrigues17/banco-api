package com.fundatec.bancoapi.controller;


import com.fundatec.bancoapi.model.Movimentacao;
import com.fundatec.bancoapi.model.contas.Conta;
import com.fundatec.bancoapi.service.CaixaAutomaticoService;
import com.fundatec.bancoapi.service.GerenciamentoClienteService;
import com.fundatec.bancoapi.service.GerenciamentoContaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BigDecimal consultarSaldo(@PathVariable Integer idConta) {
        Conta conta = contaService.findById(idConta);
        return service.consultarSaldo(conta);
    }

    @GetMapping("/extratos/{cpf}")
    public List<Movimentacao> consultarExtrato(@PathVariable String cpfTitular) {
        Conta conta = contaService.findByCpf(cpfTitular);
        return service.consultarExtrato(conta);
    }

//    @PutMapping("/depositar/{idConta}/{valor}")
//    public void depositar(@PathVariable Integer idConta, @PathVariable BigDecimal valor){
//
//        service.depositar(idConta, valor);
//    }

//    @PutMapping("/sacar/{idConta}/{valor}")
//    public void sacar(@PathVariable Integer idConta, @PathVariable BigDecimal valor){
//        service.sacar(conta, valor);
//    }

//    @PutMapping("/{idConta1}/{idConta2}/{valor}")
//    public void transferir(Conta conta1, Conta conta2){
//        service.transferir(conta1, conta2);
//    }
}
