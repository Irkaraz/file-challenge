package org.example;

import org.example.entities.DadosMercado;
import org.example.entities.Operacao;
import org.example.entities.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reader {


    public static void main(String[] args) throws IOException {

        //Leitura dos arquivos csv
        String pathOperacoes = "C:\\Users\\jessi\\IdeaProjects\\desafio\\src\\main" +
                "\\java\\org\\example\\csv\\Operacoes.csv";
        List<Operacao> operacaoList = getOperacoes(pathOperacoes);

        String pathDadosMercado = "C:\\Users\\jessi\\IdeaProjects\\desafio\\src\\main" +
                "\\java\\org\\example\\csv\\DadosMercado.csv";
        List<DadosMercado> dadosMercadoList = getDadosMercado(pathDadosMercado);

        //Percorre cada operação dentro da lista
        for (Operacao operacao : operacaoList) {
            double quantidadeAcoes = operacao.getQuantidade();
            LocalDate dataInicio = operacao.getDataInicio();
            LocalDate dataFinal = operacao.getDataFinal();
            String subProduto = operacao.getSubProduto();

            // Cálculo da quantidade de dias da operação
            long diasOperacao = ChronoUnit.DAYS.between(dataInicio, dataFinal);

            // Busca do preço da ação no DadosMercado.csv
            double precoAcao = 0;

            for (DadosMercado dadosMercado : dadosMercadoList){
                precoAcao = dadosMercado.buscarPrecoDaAcao(dadosMercadoList, dadosMercado.getCodAcao(), dadosMercado.getDiasCorridos());
            }

            double valorFinalDaOperacao = quantidadeAcoes * precoAcao;

            Result result = new Result(subProduto, valorFinalDaOperacao);
        }

    }

    //Reader do csv de operacoes
    private static List<Operacao> getOperacoes(String operacoes) throws IOException {
        File file = new File(operacoes);

        List<Operacao> operacaoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            line = reader.readLine(); // essa irá ler os dados, o primeiro lê o reader do arquivo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while (line != null) {
                String[] data = line.split(";");

                String cdOperacaoStr = data[0];
                String dataInicioStr = data[1];
                String dataFinalStr = data[2];
                String nomeEmpresa = data[3];
                String nomeMesa = data[4];
                String nomeEstrategia = data[5];
                String nomeCentralizador = data[6];
                String nomeGestor = data[7];
                String nomeSubGestor = data[8];
                String nomeSubProduto = data[9];
                String nomeCaracteristica = data[10];
                String cdAtivos = data[11];
                String quantidadeStr = data[12];
                String codAcao = data[13];

                LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
                LocalDate dataFinal = LocalDate.parse(dataFinalStr, formatter);
                double quantidade = Double.parseDouble(quantidadeStr.replace(',', '.'));

                Operacao operacao = new Operacao(dataInicio, dataFinal, quantidade, codAcao, nomeSubProduto);
                operacaoList.add(operacao);

                line = reader.readLine();
            }
        }
        return operacaoList;
    }

    private static List<DadosMercado> getDadosMercado(String dadosMercado) throws IOException {
        File file = new File(dadosMercado);

        List<DadosMercado> dadosMercadoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                String[] data = line.split(";");

                String codAcao = data[0];
                String diasCorridosStr = data[1];
                String vlPrecoStr = data[2];

                int diasCorridos = Integer.parseInt(diasCorridosStr);
                double vlPreco = Double.parseDouble(vlPrecoStr.replace(',', '.'));

                DadosMercado dadoMercado = new DadosMercado(codAcao, diasCorridos, vlPreco);
                dadosMercadoList.add(dadoMercado);

                line = reader.readLine();
            }
        }
        return dadosMercadoList;
    }
}

