package com.fundatec.banco.controller;

import com.fundatec.banco.converter.ClienteResponseConverter;
import com.fundatec.banco.converter.ContaResponseConverter;
import com.fundatec.banco.dto.ClienteResponseDto;
import com.fundatec.banco.dto.ContaResponseDto;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.service.GerenciamentoAdmService;
import com.fundatec.banco.service.GerenciamentoClienteService;
import com.fundatec.banco.service.GerenciamentoContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/administrativo")
@RequiredArgsConstructor
public class GerenciamentoAdmController {



    @Autowired
    private final GerenciamentoAdmService admService;
    @Autowired
    private final ClienteResponseConverter clienteResponseConverter;
    @Autowired
    private final GerenciamentoClienteService clienteService;
    @Autowired
    private final GerenciamentoContaService contaService;
    @Autowired
    private final ContaResponseConverter contaResponseConverter;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponseDto> newCliente(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Cliente cliente) {
        if (admService.verificarCredenciais(idBanco, senha)) {
            Cliente clienteDto = clienteService.saveCliente(cliente);
            return ResponseEntity.ok(clienteResponseConverter.convert(clienteDto));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/contaSimples")
    public ResponseEntity<ContaResponseDto> newConta(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Conta conta) {
        if (admService.verificarCredenciais(idBanco, senha)) {
            admService.verificarCredenciais(idBanco, senha);
            Conta contaDto = contaService.criarConta(conta);
            return ResponseEntity.ok(contaResponseConverter.convert(contaDto));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

//    @PostMapping("/contasPoupanca")
//    public ResponseEntity<ContaDto> newConta(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Conta conta) {
//        if (admService.verificarCredenciais(idBanco, senha)) {
//            admService.verificarCredenciais(idBanco, senha);
//            Conta contaDto = contaService.criarConta(conta);
//            return ResponseEntity.ok(contaResponseConverter.convert(contaDto));
//        }
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//    }
//
//    @PostMapping("/contasEspecial")
//    public ResponseEntity<ContaDto> newConta(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Conta conta) {
//        if (admService.verificarCredenciais(idBanco, senha)) {
//            admService.verificarCredenciais(idBanco, senha);
//            Conta contaDto = contaService.criarConta(conta);
//            return ResponseEntity.ok(contaResponseConverter.convert(contaDto));
//        }
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//    }

}
