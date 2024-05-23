package org.example.entities;

import java.time.LocalDate;

public class Operacao {
    private double cdOperacao;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private double quantidade;
    private double idPreco;


    public Operacao() {
    }

    public Operacao(double cdOperacao, LocalDate dataInicio, LocalDate dataFinal, double quantidade, double idPreco) {
        this.cdOperacao = cdOperacao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.quantidade = quantidade;
        this.idPreco = idPreco;
    }

    public double getCdOperacao() {
        return cdOperacao;
    }


    public LocalDate getDataInicio() {
        return dataInicio;
    }


    public LocalDate getDataFinal() {
        return dataFinal;
    }


    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getIdPreco() {
        return idPreco;
    }

}

