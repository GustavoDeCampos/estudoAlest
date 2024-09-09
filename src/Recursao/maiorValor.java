package Recursao;

public class maiorValor {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(maiorValorNaoRecursivo(array));
        System.out.println(maiorValorRecursivo(array,0, Integer.MIN_VALUE));

    }

    public static int maiorValorNaoRecursivo(int[] a){

        int m = Integer.MIN_VALUE;
        int tam = a.length;

        for (int i = 0; i < tam; i++){

            if (a[i]>m){
                m = a[i];
            }
        }
        return m;
    }

    public static int maiorValorRecursivo(int[] a, int i, int m){
        int tam = a.length;

        if (i < tam){

            if (a[i] > m){
                m = a[i];
            }

            i++;
            return maiorValorRecursivo(a, i, m);
        }

        return m;
    }
}
