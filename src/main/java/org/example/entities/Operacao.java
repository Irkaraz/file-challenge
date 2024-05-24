package org.example.entities;

import java.time.LocalDate;

public class Operacao {
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private double quantidade;
    private String codAcao;
    private String subProduto;


    public Operacao() {
    }

    public Operacao(LocalDate dataInicio, LocalDate dataFinal, double quantidade, String codAcao, String subProduto) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.quantidade = quantidade;
        this.codAcao = codAcao;
        this.subProduto = subProduto;
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

    public String getCodAcao() {
        return codAcao;
    }

    public String getSubProduto() {
        return subProduto;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", quantidade=" + quantidade +
                ", codAcao='" + codAcao + '\'' +
                ", subProduto='" + subProduto + '\'' +
                '}';
    }
}

