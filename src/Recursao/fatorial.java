package Recursao;

import java.util.Scanner;

public class fatorial {
    public static void main(String[] args) {
        Scanner homelander = new Scanner(System.in);

        System.out.print("Digite um numero para obter o seu valor fatorial: ");
        int f = homelander.nextInt();
        System.out.println();

        System.out.println("Fatorial de " + f + ": " + fatorial(f));

    }

    public static long fatorial(long f){
        if(f == 0 || f == 1){
            return 1;
        }else
            return f * fatorial(f - 1);
    }
}
