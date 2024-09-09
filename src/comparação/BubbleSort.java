package comparação;

public class BubbleSort {
    public static Resultado Sort(int[] vetor) {

        int trocas = 0;
        //BUBBLE SORT O(n^2)
        int aux;
        for (int i = 0; i < vetor.length; i++) { // O(n), pois varre o vetor n vezes
            for (int j = i + 1; j < vetor.length; j++) { // O(n-1) = O(n)
                if (vetor[i] > vetor[j]) {
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                    trocas++;
                }
            }
        }


        return new Resultado(vetor, trocas);
    }
}
