package Recursao;

import java.util.Arrays;
import java.util.Scanner;

public class somatorio {
    public static void main(String[] args) {

        Scanner homelander = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int n = homelander.nextInt();
        System.out.println();

        System.out.println("Somatorios: ");
        System.out.println(somatorioNaoRecursivo(n));
        System.out.println(somatorio(n));


    }

    public static int somatorioNaoRecursivo(int n) {
        int soma = 0;
        for (int i = n; i >= 0; i--) {
            soma = soma + i;
        }
        return soma;
    }

    public static int somatorio(int n){
        if (n ==1){
            return 1;
        }else
            return n + somatorio(n -1);
    }
}
