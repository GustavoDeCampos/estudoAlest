package Recursao;

import java.util.Arrays;

public class inverterArray {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9};
        inverterArrayRecursivo(array, 0);
        System.out.println(Arrays.toString(array));
    }

    public static void inverterArrayRecursivo (int[] a, int i){
        int tam = a.length;
        if (i < tam / 2){
            int temp = a[i];
            a[i] = a[tam - 1 - i];
            a[tam - 1 - i] = temp;
            i++;
            inverterArrayRecursivo(a, i);
        }
    }
}
