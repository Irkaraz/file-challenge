package org.example.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private final String Subproduto;
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

    public static List<String> getAgrupado(List<Result> resultList) {
        Map<String, List<Result>> subprodutoAgrupado = resultList.stream().collect(Collectors.groupingBy(Result::getSubproduto));
        List<String> valorAcaoAgrupado = new ArrayList<>();

        for (String subProduto : subprodutoAgrupado.keySet()) {
            List<Result> subproduto1 = subprodutoAgrupado.get(subProduto);
            double valorAcao = subproduto1.stream().reduce(0.0, (acumulador, subProduto2) -> acumulador + subProduto2.valorFinal, Double::sum);
            valorAcaoAgrupado.add(subProduto + ";" + valorAcao);
        }

        return valorAcaoAgrupado;
    }

}
