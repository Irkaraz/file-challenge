package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MexendoComMap {
    public static void main(String[] args) {

        Pessoa jessicaSantos = new Pessoa("Jessica Santos", 20, 2000);
        Pessoa leandroLeite = new Pessoa("Leandro Leite", 24,  5000);
        Pessoa pauloLeite = new Pessoa("Paulo Leite", 21, 500000);
        Pessoa larissa = new Pessoa("Larissa", 24, 4500);
        Pessoa victorLeite = new Pessoa("Victor Leite", 20, 10);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(jessicaSantos);
        pessoas.add(leandroLeite);
        pessoas.add(pauloLeite);
        pessoas.add(larissa);
        pessoas.add(victorLeite);

        Map<Integer, List<Pessoa>> pessoasAgrupadasPorIdade =
                pessoas.stream().collect(Collectors.groupingBy(pessoa -> pessoa.age));

        System.out.println(pessoasAgrupadasPorIdade);
        // queremso a soma de todos os salarios de um grupo por idade

        for(Integer age : pessoasAgrupadasPorIdade.keySet()) {
            List<Pessoa> pessoas1 = pessoasAgrupadasPorIdade.get(age);

            int soma1 = pessoas1.stream().mapToInt(p -> p.salary).sum();
            System.out.println(soma1);


            int soma = pessoas1.stream().reduce(0, (acumulador, p2) -> acumulador + p2.salary, Integer::sum);
            System.out.println(soma);
        }


    }
}
