package com.fundatec.bancoapi.model.contas;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

    private final double taxaJuros = 0.0015;

    public ContaPoupanca() {
        long startTime = System.nanoTime();
        gerarRendimentos(startTime);
    }

    public void gerarRendimentos(long startTime){
//        for (System.currentTimeMillis(); System.currentTimeMillis() < System. ;) {
//            BigDecimal saldoAtual = getSaldo();
//            BigDecimal saldoNovo = saldoAtual.multiply(BigDecimal.valueOf(taxaJuros));
//            getSaldo().add(saldoNovo);
//        }
        boolean renderSaldo = true;
        //if (getStatus.equals){
        // renderSaldo = false;
        // }
        while(renderSaldo){
            if (System.nanoTime() >= startTime) {
                BigDecimal saldoAtual = getSaldo();
                BigDecimal saldoNovo = saldoAtual.multiply(BigDecimal.valueOf(taxaJuros));
                getSaldo().add(saldoNovo);
            }
        }

    }

}
