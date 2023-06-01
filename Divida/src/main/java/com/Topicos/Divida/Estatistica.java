package com.Topicos.Divida;

import java.util.*;
import java.util.stream.Collectors;



public class Estatistica {

    private List<Integer> entrada;


    public List<Integer> getEntrada() {
        return entrada;
    }

    public void setEntrada(List<Integer> entrada) {
        this.entrada = entrada;
    }

    public Estatistica(List<Integer> entrada){
        this.entrada = entrada;
    }

    public double media() {
        return entrada.stream().mapToInt(n -> n).average().getAsDouble();
    }

    public List<Integer> ordena(){

        return entrada.stream().sorted((i1,i2) -> i1.compareTo(i2)).collect(Collectors.toList());
    }

    public double mediana() {
        int tamanho = entrada.size();
        List<Integer> ordenado = ordena();
        double mediana = 0;
        double posicao;
        if(tamanho % 2 != 0) {
            posicao = (double) Math.ceil(tamanho/2);
            mediana = ordenado.get((int) posicao);
        } else {
            posicao = tamanho/2;
            double posicao2 = posicao -1;
            double a = ordenado.get((int) posicao);
            double b = ordenado.get((int) posicao2);
            mediana = (a+b)/2;
        }
        return mediana;
    }

    public Map<Integer, Long> frequencia() {
        return entrada.stream().collect(Collectors.groupingBy(n -> n,Collectors.counting()));
    }

    public Map<Integer, Long> moda(){
        Map<Integer, Long> frequencias = frequencia();
        Long valor = Collections.max(frequencias.values());

        Map<Integer, Long> indice = frequencias.entrySet().stream().filter(n -> n.getValue().equals(valor)).collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue()));
        return indice;
    }

    public Integer amplitude(){
        int min =entrada.stream().mapToInt(n ->n).min().getAsInt();
        int max = entrada.stream().mapToInt(n ->n).max().getAsInt();
        return max - min;
    }
    /*
    public double calcularDesvioPadrao() {
        // Calcula a média
        double media = media();

        // Calcula a soma dos quadrados das diferenças em relação à média
        double somaQuadrados = 0;
        for (double numero : entrada) {
            double diferenca = numero - media;
            somaQuadrados += diferenca * diferenca;
        }

        // Calcula a média dos quadrados das diferenças
        double mediaQuadrados = somaQuadrados / entrada.size();

        // Calcula a raiz quadrada da média dos quadrados das diferenças (desvio padrão)
        double desvioPadrao = Math.sqrt(mediaQuadrados);

        return desvioPadrao;
    }*/

}
