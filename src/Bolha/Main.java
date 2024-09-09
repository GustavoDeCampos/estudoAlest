package Bolha;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[100];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * 100);
            System.out.println(vetor[i]);
        }
        //BUBBLE SORT O(n^2)
        int aux;
        for (int i = 0; i < vetor.length; i++){ // O(n), pois varre o vetor n vezes
            for (int j = i + 1; j < vetor.length; j++){ // O(n-1) = O(n)
                if (vetor[i] > vetor[j]){
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }

        System.out.println("Vetor ordenado:");
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
    }
}
