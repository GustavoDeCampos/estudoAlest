package exercicio1;

public class Main {

    public static void main(String[] args) {

        System.out.println("alg1:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_01(n));
        }

        System.out.println();
        System.out.println("alg2:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_02(n));
        }

        System.out.println();
        System.out.println("alg3:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_03(n));
        }

        System.out.println();
        System.out.println("alg4:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_04(n));
        }

        System.out.println();
        System.out.println("alg5:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_05(n));
        }

        System.out.println();
        System.out.println("alg6:");
        System.out.println("n;operações");
        for (int n = 0; n < 100; n++){
            System.out.println(n + ";" + alg_06(n));
        }

        System.out.println();
        System.out.println("alg7:");
        System.out.println("n;operações");
        for (int n = 0; n < 10000; n+=100){
            System.out.println(n + ";" + alg_07(n));
        }
    }

    public static int alg_01(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++) {
            operacoes++;
        }
        operacoes = 3*operacoes+3;
        return operacoes;
    }

    public static int alg_02(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                operacoes++;
        return operacoes;
    }

    public static int alg_03(int n) {
        return 100;
    }

    public static int alg_04(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < i + 2; j++)
                for (int k = 0; k < n; k++)
                    operacoes++;
        return operacoes;
    }

    public static int alg_05(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < 2 * i; j++)
                operacoes++;
        return operacoes;
    }

    public static long alg_06(int n) {
        long operacoes = 1;
        for (int i = 1; i <= n / 2; i++) {
            operacoes = operacoes * n;
            if (operacoes >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return operacoes;
    }

    public static int alg_07(int n) {
        int operacoes = 0;
        int aux = n;
        do {
            aux = aux / 2;
            operacoes++;
        }while(aux>1);
        return operacoes;
    }
}

