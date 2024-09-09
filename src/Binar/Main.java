package Binar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[10000];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = i * 2;
            //System.out.println(vetor[i]);
        }

        System.out.println("Qual numero voce busca?");
        Scanner homelander = new Scanner(System.in);
        int buscado = homelander.nextInt();

        int contador = 0;
        boolean achou = false;
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;

        while (inicio <= fim){
            meio = (int) ((inicio + fim) / 2);
            contador++; //conta quantos testes a busca fez
            if (vetor[meio] == buscado){
                achou = true;
                break;
            }else if (vetor[meio] < buscado){
                inicio = meio + 1;
            }else{//só pode ser maior
                fim = meio - 1;
            }
        }
        System.out.println("Quantidade de testes: " + contador);
        if (achou){
            System.out.println("Achou!");
        }else {
            System.out.println("Não achou!");
        }
    }
}
