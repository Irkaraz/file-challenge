package org.example.entities;

public class Result {
    private String Subproduto;
    private double valorFinal;

    public Result(String subproduto, double valorFinal) {
        Subproduto = subproduto;
        this.valorFinal = valorFinal;
    }

    public String getSubproduto() {
        return Subproduto;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
