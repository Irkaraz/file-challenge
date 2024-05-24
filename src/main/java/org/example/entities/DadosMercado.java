package org.example.entities;

import java.util.List;

public class DadosMercado {

    private String codAcao;
    private int diasCorridos;
    private double vlPreco;

    public DadosMercado() {
    }

    public DadosMercado(String codAcao, int diasCorridos, double vlPreco) {
        this.codAcao = codAcao;
        this.diasCorridos = diasCorridos;
        this.vlPreco = vlPreco;
    }

    public double buscarPrecoDaAcao(List<DadosMercado> dadosMercadoList, String codAcao, int diasCorridos){
        for (DadosMercado dadoMercado : dadosMercadoList){
            if (dadoMercado.getCodAcao().equals(codAcao) && dadoMercado.getDiasCorridos() == diasCorridos){
                return dadoMercado.getVlPreco();
            }
        }
        throw new IllegalArgumentException("Preço não encontrado para ação: " + codAcao + " e dias: " + diasCorridos);
    }

    public String getCodAcao() {
        return codAcao;
    }

    public int getDiasCorridos() {
        return diasCorridos;
    }

    public void setDiasCorridos(int diasCorridos) {
        this.diasCorridos = diasCorridos;
    }

    public double getVlPreco() {
        return vlPreco;
    }

    public void setVlPreco(double vlPreco) {
        this.vlPreco = vlPreco;
    }

    @Override
    public String toString() {
        return "DadosMercado" +
                "idPreco= " + codAcao +
                ", diasCorridos= " + diasCorridos +
                ", vlPreco= " + vlPreco;
    }
}
