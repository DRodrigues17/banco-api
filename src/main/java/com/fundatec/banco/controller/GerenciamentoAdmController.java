package com.fundatec.banco.controller;

import com.fundatec.banco.converter.ClienteResponseConverter;
import com.fundatec.banco.converter.ContaResponseConverter;
import com.fundatec.banco.dto.BancoDto;
import com.fundatec.banco.dto.ClienteDto;
import com.fundatec.banco.dto.ContaDto;
import com.fundatec.banco.model.Banco;
import com.fundatec.banco.model.contas.Conta;
import com.fundatec.banco.model.pessoas.Cliente;
import com.fundatec.banco.service.GerenciamentoAdmService;
import com.fundatec.banco.service.GerenciamentoClienteService;
import com.fundatec.banco.service.GerenciamentoContaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/administrativo")
@RequiredArgsConstructor
public class GerenciamentoAdmController {


    private final GerenciamentoAdmService admService;
    private final ClienteResponseConverter clienteResponseConverter;
    private final GerenciamentoClienteService clienteService;

    private final GerenciamentoContaService bancoService;
    private final GerenciamentoContaService contaService;
    private final ContaResponseConverter contaResponseConverter;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteDto> newCliente(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Cliente cliente) {
        if (admService.verificarCredenciais(idBanco, senha)) {
            Cliente clienteDto = clienteService.saveCliente(cliente);
            return ResponseEntity.ok(clienteResponseConverter.convert(clienteDto));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/contas")
    public ResponseEntity<ContaDto> newConta(@RequestHeader Integer idBanco, @RequestHeader String senha, @RequestBody Conta conta) {
        if (admService.verificarCredenciais(idBanco, senha)) {
            admService.verificarCredenciais(idBanco, senha);
            Conta contaDto = contaService.criarConta(conta);
            return ResponseEntity.ok(contaResponseConverter.convert(contaDto));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


}
