package comparação;

import static java.util.Arrays.sort;

public class QuickSort {
    static int trocas = 0;

    public static Resultado Sort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivo = particao(vetor, esquerda, direita);
            sort(vetor, esquerda, pivo);
            sort(vetor, pivo + 1, direita);
        }
        return new Resultado(vetor, trocas);
    }

    static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita;
        while (true) {
            do {
                i++;
            } while (vetor[i] < pivot);
            do {
                j--;
            } while (vetor[j] > pivot);
            if (i >= j) {
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            trocas++;
        }
    }
}

